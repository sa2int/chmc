package io.bigtreelab.rndbox.api.servicedomain;

import io.bigtreelab.rndbox.api.domain.user.User;
import io.bigtreelab.rndbox.api.dto.user.UserRequestDto;
import io.bigtreelab.rndbox.api.dto.user.UserResponseDto;
import io.bigtreelab.rndbox.api.repository.SignRepository;
import io.bigtreelab.rndbox.api.repository.UserRepository;
import io.bigtreelab.rndbox.api.utils.AES256Security;
import io.bigtreelab.rndbox.api.utils.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDomain {

    private final UserRepository userRepository;
    private final SignRepository signRepository;
    private final AES256Security aes256;

    /**
     * 휴대폰번호로 숫자만 입력되어야 한다.
     *
     * @param cellphone
     * @return
     */
    public Long getUserNoWithUserId(String cellphone) {
        String cipherText = null;
        try {
            if (ObjectUtils.isEmpty(cellphone)) {
                return 0L;
            }
            cipherText = getEncrypt(cellphone);
            if (ObjectUtils.isEmpty(cipherText)) {
                return 0L;
            }
            Long userNo = userRepository.getUserNoWithUserId(cipherText);
            if (ObjectUtils.isEmpty(userNo)) {
                return 0L;
            }
            return userNo;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 휴대폰번호로 숫자만 입력되어야 한다.
     */
    public String getEncryptWithUserId(String userId) {
        String cipherText = null;
        try {
            if (ObjectUtils.isEmpty(userId)) {
                return cipherText;
            }

            return getEncrypt(userId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return cipherText;
        }
    }

    public String getEncrypt(String text) {

        try {
            return aes256.encrypt(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return text;
    }

    public String getDecrypt(String text) {
        String cipherText = null;
        try {
            if (ObjectUtils.isEmpty(text)) {
                return cipherText;
            }

            return aes256.decrypt(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void updateUserWithLastLoginDate(User user) {
        user.setLastLoginDate(DateTimeUtils.nowFromZone());
        user.setRegistrationId(user.getRegistrationId());
        user.setUpdatedBy(user.getUserNo());
        user.setUpdatedDate(DateTimeUtils.nowFromZone());
        signRepository.updateUserWithLastLoginDate(user);
    }

    public UserResponseDto findUserInfo(Long userNo) {
        // TODO Auto-generated method stub
        return userRepository.findUserInfo(userNo);
    }

    /**
     * 휴대폰번호를 암호화를 해제한 데이타
     *
     * @param userNo
     * @return
     */
    public UserResponseDto findUserInfoWithDecrypt(Long userNo) {
        // TODO Auto-generated method stub
        UserResponseDto user = findUserInfo(userNo);
        user.setCellphone(getDecrypt(user.getCellphone()));
        return user;
    }

    public void updateUser(UserRequestDto userRequestDto) {
        // TODO Auto-generated method stub

        if (ObjectUtils.isEmpty(userRequestDto.getBirthday())) {
            userRepository.updateUser(User.builder().userNo(userRequestDto.getUserNo())
                    .cellphone(getEncryptWithUserId(userRequestDto.getCellphone())).nickName(userRequestDto.getNickName())
                    .avata(userRequestDto.getAvata())
                    .gender(userRequestDto.getGender()).updatedBy(userRequestDto.getUserNo())
                    .updatedDate(DateTimeUtils.nowFromZone()).build());
        } else {
            userRepository.updateUser(User.builder().userNo(userRequestDto.getUserNo())
                    .cellphone(getEncryptWithUserId(userRequestDto.getCellphone()))
                    .nickName(userRequestDto.getNickName()).avata(userRequestDto.getAvata())
                    .birthday(LocalDate.parse(userRequestDto.getBirthday(), DateTimeFormatter.ISO_DATE))
                    .gender(userRequestDto.getGender()).updatedBy(userRequestDto.getUserNo())
                    .updatedDate(DateTimeUtils.nowFromZone()).build());
        }
    }

    public void updateUserCellphone(UserRequestDto userRequestDto) {
        // TODO Auto-generated method stub
        userRepository.updateUserCellphone(User.builder().userNo(userRequestDto.getUserNo())
                .cellphone(getEncryptWithUserId(userRequestDto.getCellphone())).updatedBy(userRequestDto.getUserNo())
                .updatedDate(DateTimeUtils.nowFromZone()).build());
    }

    /**
     * 주문취소로 누적 차감 처리
     */
    public void accumulatePayAmountWithPayCancel(Long userNo, BigDecimal paymentAmount) {
        userRepository
                .updatePayAmount(User.builder().userNo(userNo).payAmount(paymentAmount.multiply(new BigDecimal("-1")))
                        .updatedBy(userNo)
                        .updatedDate(DateTimeUtils.nowFromZone()).build());

    }

}
