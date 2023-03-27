package io.bigtreelab.rndbox.api.dto.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.bigtreelab.rndbox.api.enums.BannerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto implements Serializable {

    /**유저번호*/
    @JsonIgnore
	private Long userNo;
	/**유저아이디*/
	@JsonIgnore
	private String userId;
	/**유저명*/
	@JsonIgnore
	private String userName;
	/**닉네임*/
	private String nickName;
	/**아바타*/
	private String avata;
	/**패스워드*/
	@JsonIgnore
	private String password;
	/**성별*/
	private String gender;
	@JsonIgnore
	private String genderCodeName;
	/**생년월일*/
	private LocalDate birthday;
	/**이메일*/
	@JsonIgnore
	private String email;
	/**휴대폰번호*/
	private String cellphone;
	/**가입일자*/
	@JsonIgnore
	private LocalDate joinDate;
	/**마지막로그인날짜*/
	@JsonIgnore
	private LocalDateTime lastLoginDate;
	/**탈퇴여부*/
	@JsonIgnore
	private String quitYn;
	/**탈퇴일자*/
	@JsonIgnore
	private LocalDateTime quitDate;
	/**메일수신여부*/
	@JsonIgnore
	private String emailAllowYn;
	/**SMS수신여부*/
	@JsonIgnore
	private String smsAllowYn;
	/**모바일푸쉬수신여부*/
	private String pushAllowYn;
	/**로그인실패회수*/
	@JsonIgnore
	private Integer loginFailNum;
	/**로그인가능시간*/
	@JsonIgnore
	private LocalDateTime loginPossibleDate;
	/**구매여부*/
	@JsonIgnore
	private String buyYn;
	/**가입경로*/
	@JsonIgnore
	private BannerType joinType;
	
	
	
	
	
}
