package io.bigtreelab.rndbox.api.dto.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

import io.bigtreelab.rndbox.api.domain.user.UserDevice;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;

import io.bigtreelab.rndbox.api.domain.user.User;
import io.bigtreelab.rndbox.api.enums.GenderType;
import io.bigtreelab.rndbox.api.utils.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter	
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignupRequestDto {
   
	/** 유저아이디 */
	@ApiModelProperty(required = true, value = "유저아이디", example = "wechat", hidden = false)
	private String userId;
	/**유저명*/
	@ApiModelProperty(required = false, value = "유저명", example = "고객명", hidden = true)
	private String userName;
	/**휴대폰번호*/
	@ApiModelProperty(required = false, value = "휴대폰번호", example = "", hidden = false)
	private String cellphone;
	/**가입경로*/
	@ApiModelProperty(required = false, value = "가입경로10 휴대폰, 20 위챗", example = "10", hidden = true)
	private String joinType;
	/**닉네임*/
	@ApiModelProperty(required = false, value = "닉네임", example = "SNS 제공하는 닉네임",  hidden=false)
	private String nickName;
	/** 프로필사진 */
	@ApiModelProperty(required = false, value = "프로필사진", example = "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0", hidden = false)
	private String avata;
	/**패스워드*/
	@ApiModelProperty(required = false, value = "패스워드", example = "", hidden = true)
	private String password;
	/**성별*/
	@ApiModelProperty(required = false, value = "성별F/M", example = "1", hidden = false)
	private String gender;
	@ApiModelProperty(required = false, value = "생년월일", example = "yyyy/mm/dd", hidden = false)
	private LocalDate birthday;
	@ApiModelProperty(required = true, value = "푸쉬 유저 구분자", example = "", hidden = false)
	private String registrationId;


    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .userId(userId)
                .password( ObjectUtils.isEmpty(password)
                		? passwordEncoder.encode(Constants.STRING_BLANK)
                		: passwordEncoder.encode(password))
                .nickName(nickName)
                .userName(userName)
				.avata(avata)
				.birthday(birthday)
                .cellphone(cellphone)
				.gender(makeGender())
                .joinDate(LocalDate.now())
                .lastLoginDate(LocalDateTime.now())
                .quitYn(Constants.STRING_NO)
                .loginFailNum(Constants.INTEGER_ZERO)
				.joinType(joinType)
				.registrationId(registrationId)
                .roles(Collections.singletonList(Constants.USER_ROLE))
                .createdBy(Constants.SYSTEM_USER)
                .createdDate(LocalDateTime.now())
                .updatedBy(Constants.SYSTEM_USER)
                .updatedDate(LocalDateTime.now())
                .build();
    }
    
	private String makeGender() {

		if (ObjectUtils.isEmpty(this.gender)) {
			return null;
		}

		if (this.gender.equals(GenderType.FEMALE.getGenderGubun())) {
			return GenderType.FEMALE.getCode();
		}
		if (this.gender.equals(GenderType.MALE.getGenderGubun())) {
			return GenderType.MALE.getCode();
		}
		return null;

	}

}