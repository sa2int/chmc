package io.bigtreelab.rndbox.api.service.security;

import io.bigtreelab.rndbox.api.advice.exception.*;
import io.bigtreelab.rndbox.api.domain.user.*;
import io.bigtreelab.rndbox.api.dto.user.*;
import io.bigtreelab.rndbox.api.repository.UserRepository;
import io.bigtreelab.rndbox.api.utils.DateTimeUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import io.bigtreelab.rndbox.api.config.security.JwtTokenProvider;
import io.bigtreelab.rndbox.api.domain.security.RefreshToken;
import io.bigtreelab.rndbox.api.dto.jwt.TokenDto;
import io.bigtreelab.rndbox.api.dto.jwt.TokenRequestDto;
import io.bigtreelab.rndbox.api.enums.JoinType;
import io.bigtreelab.rndbox.api.repository.RefreshTokenRepository;
import io.bigtreelab.rndbox.api.repository.SignRepository;
import io.bigtreelab.rndbox.api.servicedomain.UserDomain;
import io.bigtreelab.rndbox.api.utils.AES256Security;
import io.bigtreelab.rndbox.api.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignService {
	private final SignRepository signRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtProvider;
	private final RefreshTokenRepository tokenRepository;
	private final AES256Security aes256;
	private final UserDomain userDomain;
	private final UserRepository userRepository;

	/**
	 * 휴대폰번호로 로그인 휴대폰번호가 아이디로 사용 아이디가 없으면 무조건 회원 가입
	 * 
	 * @param cellphone
	 * @return
	 */
	@Transactional
	public TokenDto signinByCellphone(String cellphone, String registrationId) {
		String userId = cellphone;
		String cipherCellphoneText = null;
		try {
			cipherCellphoneText = aes256.encrypt(cellphone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("유저아이디 암호화 오류입니다.");
			throw new RuntimeException();
		}

		//탈퇴 회원 조회
		User quitUser = userRepository.selectUserInQuitY(User.builder().cellphone(cipherCellphoneText).build());
		//30일이내 탈퇴한 회원 탈퇴철회
		if(!ObjectUtils.isEmpty(quitUser)) {
			log.info("탈퇴한 회원입니다." + quitUser.getUserNo());
			userRepository.updateUserCancelQuit(User.builder().cellphone(cipherCellphoneText).userNo(quitUser.getUserNo()).updatedDate(DateTimeUtils.nowFromZone()).build());

			List<User> memberList =userRepository.selectMember(UserRequestDto.builder().userNo(quitUser.getUserNo()).build());

			for(User member : memberList) {
				userRepository.updateUserCancelQuitForWeChat(User.builder().userNo(member.getUserNo())
						.userId(member.getUserId().substring(0,member.getUserId().lastIndexOf("@")))
						.memberNo(member.getMemberNo())
						.updatedBy(member.getUserNo())
						.updatedDate(DateTimeUtils.nowFromZone()).build());
			}
//			//탈퇴 메세지 "탈퇴처리된 유저 입니다. 탈퇴를 철회하시겠습니까?"
//			throw new QuitUserException();
		}

		User user = signRepository
				.findUserByUserId(UserSignupRequestDto.builder().joinType(JoinType.CELLPHONE.getCode())
						.userId(cipherCellphoneText)
				.build());

		if(!ObjectUtils.isEmpty(user)) {
			//ban유저 검색
			int banUser = userRepository.selectBanUser(user.getUserNo());
			if(banUser != 0) {
				log.info("밴 유저 입니다.");
				throw new CBanException();
			}
		}
		
		if (ObjectUtils.isEmpty(user)) {
			// 회원가입
			log.info("회원가입로그입니다!");

			//닉네임 가져오기
			int idx = signRepository.countNickName();
			Random random = new Random();
			int randomIdx = random.nextInt(idx)+1;

			NickName nickName;
			nickName = signRepository.getNickName1(randomIdx);

			if (nickName == null) {
				//닉네임 최대값(idx) 사용시 최대값 역순으로 가져오기;
				nickName = signRepository.getNickName2(randomIdx);
			}

			Long uno = signup(UserSignupRequestDto.builder().nickName(nickName.getNickName()).userId(cipherCellphoneText)
					.cellphone(cipherCellphoneText)
					.registrationId(registrationId)
					.joinType(JoinType.CELLPHONE.getCode())
					.avata("https://xing-app-ui.oss-cn-beijing.aliyuncs.com/profile/profile.png")
					.build());

			nickName.setCreatedBy(Constants.SYSTEM_USER);
			nickName.setUpdatedBy(Constants.SYSTEM_USER);
			signRepository.updateNickNameCadidate(nickName);

		}

		user = signRepository.findUserByCellphone(
				UserSignupRequestDto.builder().cellphone(cipherCellphoneText)
						.build());
		user.setRoles(signRepository.findUserRoles(user.getUserNo()));


		// AccessToken, RefreshToken 발급
		TokenDto tokenDto = jwtProvider.createTokenDto(user.getUserNo(), user.getRoles());
		tokenDto.setUserid(userId);

        // RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .userNo(user.getUserNo())
                .token(tokenDto.getRefreshToken())
                .build();
		if(registrationId != null) {
			user.setRegistrationId(registrationId);
			//레지스트레이션아이디 초기화
			signRepository.initRegistrationId(User.builder().registrationId(user.getRegistrationId()).userNo(user.getUserNo()).build());
		}

		tokenRepository.save(refreshToken);
		userDomain.updateUserWithLastLoginDate(user);
		return tokenDto;
	}

	@Transactional
	public Long signup(UserSignupRequestDto userSignupDto) {

		User user = userSignupDto.toEntity(passwordEncoder);
		User userInfo = signRepository.findUserByCellphone(userSignupDto);
		if (ObjectUtils.isEmpty(userInfo)) {
			signRepository.saveUser(user);
			signRepository.saveUserRoles(UserRoles.builder().userNo(user.getUserNo()).role("ROLE_USER").build());
		} else {
			user.setUserNo(userInfo.getUserNo());
		}
		signRepository.saveMember(user);

		return user.getUserNo();
	}

	@Transactional
	public TokenDto reissue(TokenRequestDto tokenRequestDto) {

		// 만료된 refresh token 에러
		if (!jwtProvider.validationToken(tokenRequestDto.getRefreshToken())) {
			throw new CRefreshTokenException();
		}

		// AccessToken 에서 Username (pk) 가져오기
		String accessToken = tokenRequestDto.getAccessToken();
		Authentication authentication = jwtProvider.getAuthentication(accessToken);

		// user pk로 유저 검색 / repo 에 저장된 Refresh Token 이 없음
		User user = signRepository.findByUserNo(Long.parseLong(authentication.getName()));
		if (ObjectUtils.isEmpty(user))
			throw new CUserNotFoundException();

		RefreshToken refreshToken = tokenRepository.findByUserNo(user.getUserNo());

		if (ObjectUtils.isEmpty(refreshToken))
			throw new CRefreshTokenException();

		// 리프레시 토큰 불일치 에러
		if (!refreshToken.getToken().equals(tokenRequestDto.getRefreshToken()))
			throw new CRefreshTokenException();

		//ban유저 검색
		int banUser = userRepository.selectBanUser(user.getUserNo());
		if(banUser != 0) {
			log.info("밴 유저 입니다.");
			throw new CBanException();
		}

		// AccessToken, RefreshToken 토큰 재발급, 리프레쉬 토큰 저장
		TokenDto newCreatedToken = jwtProvider.createTokenDto(user.getUserNo(), user.getRoles());
		RefreshToken updateRefreshToken = refreshToken.updateToken(newCreatedToken.getRefreshToken());
		tokenRepository.save(updateRefreshToken);

		return newCreatedToken;
	}

}
