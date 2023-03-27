package io.bigtreelab.rndbox.api.domain.user;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigtreelab.rndbox.api.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
	
	/**유저번호*/
	private Long userNo;
	/**유저아이디*/
	private String userId;
	/**유저명*/
	private String userName;
	/**닉네임*/
	private String nickName;
	/**아바타*/
	private String avata;
	/**패스워드*/
	private String password;
	/**성별*/
	private String gender;
	/**생년월일*/
	private LocalDate birthday;
	/**이메일*/
	private String email;
	/**휴대폰번호*/
	private String cellphone;
	/**가입일자*/
	private LocalDate joinDate;
	/**마지막로그인날짜*/
	private LocalDateTime lastLoginDate;
	/**탈퇴여부*/
	private String quitYn;
	/**탈퇴일자*/
	private LocalDateTime quitDate;
	/**메일수신여부*/
	private String emailAllowYn;
	/**SMS수신여부*/
	private String smsAllowYn;
	/**모바일푸쉬수신여부*/
	private String pushAllowYn;
	/**로그인실패회수*/
	private Integer loginFailNum;
	/**로그인가능시간*/
	private LocalDateTime loginPossibleDate;
	/**가입경로*/
	private String joinType;
	/**생성자*/
	private Long createdBy;
	/**생성일자*/
	private LocalDateTime createdDate;
	/**수정자*/
	private Long updatedBy;
	/**수정일자*/
	private LocalDateTime updatedDate;

    private List<String> roles;
    
	private BigDecimal payAmount;

	private String registrationId;

	private Long memberNo;
    
	
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles
				.stream().map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
        
	
    @Override
    public String getPassword() {
        return this.password;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return String.valueOf(this.userNo);
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
		return quitYn.equals(Constants.STRING_NO);
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }

	

}