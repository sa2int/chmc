package io.bigtreelab.rndbox.api.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInqueryRequestDto {
	@ApiModelProperty(required = true, value = "보드아이디", example = "", hidden = true)
	private Long boardId;
	@ApiModelProperty(required = true, value = "문의유형 10:배송관련 20:이벤트관련 30:오류관련 40:고객응대불만 50:제품제안 60:기타의견", example = "문의유형", hidden = false)
	private String inqueryType;
	@ApiModelProperty(required = false, value = "제목", example = "제목", hidden = false)
	private String title;
	@ApiModelProperty(required = true, value = "내용", example = "내용", hidden = false)
	private String content;
	@ApiModelProperty(required = false, value = "휴대폰번호", example = "숫자만입력", hidden = false)
	private String cellphone;
	@ApiModelProperty(required = true, value = "보드아이디", example = "", hidden = true)
	private Long userNo;

}
