package io.bigtreelab.rndbox.api.dto.user;


import org.springframework.web.multipart.MultipartFile;

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
public class UserRequestDto {
	
	@ApiModelProperty(required = false, value = "유저번호", example = "", hidden = true)
	private long userNo;
	@ApiModelProperty(required = false, value = "아이디", example = "", hidden = true)
	private String userId;
	@ApiModelProperty(required = false, value = "이름", example = "", hidden = true)
    private String userName;
	@ApiModelProperty(required = false, value = "프로필", example = "", hidden = false)
	private String avata;
	@ApiModelProperty(required = false, value = "닉네임", example = "", hidden = false)
	private String nickName;
	@ApiModelProperty(required = false, value = "휴대폰번호", example = "", hidden = true)
	private String cellphone;
	@ApiModelProperty(required = false, value = "생년월일", example = "", hidden = false)
	private String birthday;
	@ApiModelProperty(required = false, value = "성별", example = "", hidden = false)
	private String gender;
	@ApiModelProperty(required = false, value = "프로필이미지URL", example = "", hidden = false)
	private MultipartFile imgUrl;
    
}
