package io.bigtreelab.rndbox.api.controller.v1;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.bigtreelab.rndbox.api.dto.jwt.TokenDto;
import io.bigtreelab.rndbox.api.dto.jwt.TokenRequestDto;
import io.bigtreelab.rndbox.api.dto.user.UserSignupRequestDto;
import io.bigtreelab.rndbox.api.response.ResponseResult;
import io.bigtreelab.rndbox.api.service.ResponseService;
import io.bigtreelab.rndbox.api.service.security.SignService;
import lombok.RequiredArgsConstructor;


@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

	private final SignService securityService;
	private final ResponseService responseService;
	// private final JwtTokenProvider jwtTokenProvider;
    
	@ApiOperation(value = "휴대폰 로그인", notes = "휴대폰번호로 로그인을 한다.")
	@GetMapping(value = "/signin/{cellphone}")
	public ResponseResult<TokenDto> signinByCellphone(
			@ApiParam(value = "휴대폰번호", example = "1", required = true) @PathVariable String cellphone) {
		TokenDto tokenDto = securityService.signinByCellphone(cellphone, "");
		return responseService.getResponseResult(tokenDto);
	}

	@ApiOperation(value = "휴대폰 로그인", notes = "휴대폰번호로 로그인을 한다.")
	@GetMapping(value = "/signin/{cellphone}/{registrationId}")
	public ResponseResult<TokenDto> signinByCellphone(
			@ApiParam(value = "휴대폰번호", example = "1", required = true) @PathVariable String cellphone,
			@ApiParam(value = "푸쉬 유저 구분자", example = "1", required = true) @PathVariable String registrationId) {

		TokenDto tokenDto = securityService.signinByCellphone(cellphone, registrationId);
		return responseService.getResponseResult(tokenDto);
	}

    @ApiOperation(
            value = "액세스, 리프레시 토큰 재발급",
            notes = "엑세스 토큰 만료시 회원 검증 후 리프레쉬 토큰을 검증해서 액세스 토큰과 리프레시 토큰을 재발급합니다.")
    @PostMapping("/reissue")
    public ResponseResult<TokenDto> reissue(
            @ApiParam(value = "토큰 재발급 요청 DTO", required = true)
            @RequestBody TokenRequestDto tokenRequestDto) {
        return responseService.getResponseResult(securityService.reissue(tokenRequestDto));
    }
	  
	/*
	 * @ApiOperation(value = "소셜 로그인", notes = "소셜 회원 로그인을 한다.")
	 * 
	 * @PostMapping(value = "/signin/{provider}") public SingleResult<String>
	 * signinByProvider(
	 * 
	 * @ApiParam(value = "서비스 제공자 provider", required = true, defaultValue =
	 * "kakao") @PathVariable String provider,
	 * 
	 * @ApiParam(value = "소셜 access_token", required = true) @RequestParam String
	 * accessToken) {
	 * 
	 * KakaoProfile profile = kakaoService.getKakaoProfile(accessToken); User user =
	 * userJpaRepo.findByUidAndProvider(String.valueOf(profile.getId()),
	 * provider).orElseThrow(CUserNotFoundException::new); return
	 * responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(
	 * user.getMsrl()), user.getRoles())); }
	 */

    
    

	/*
	 * @ApiOperation(value = "소셜 계정 가입", notes = "소셜 계정 회원가입을 한다.")
	 * 
	 * @PostMapping(value = "/signup/{provider}") public CommonResult
	 * signupProvider(@ApiParam(value = "서비스 제공자 provider", required = true,
	 * defaultValue = "kakao") @PathVariable String provider,
	 * 
	 * @ApiParam(value = "소셜 access_token", required = true) @RequestParam String
	 * accessToken,
	 * 
	 * @ApiParam(value = "이름", required = true) @RequestParam String name) {
	 * 
	 * KakaoProfile profile = kakaoService.getKakaoProfile(accessToken);
	 * Optional<User> user =
	 * userJpaRepo.findByUidAndProvider(String.valueOf(profile.getId()), provider);
	 * if (user.isPresent()) throw new CUserExistException();
	 * 
	 * User inUser = User.builder() .uid(String.valueOf(profile.getId()))
	 * .provider(provider) .name(name)
	 * .roles(Collections.singletonList("ROLE_USER")) .build();
	 * 
	 * userJpaRepo.save(inUser); return responseService.getSuccessResult(); }
	 */
}