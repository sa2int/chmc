package io.bigtreelab.rndbox.api.dto.user;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInqueryDto {

	@ApiModelProperty(required = true, value = "문의유형 10:배송관련 20:이벤트관련 30:오류관련 40:고객응대불만 50:제품제안 60:기타의견", example = "문의유형", hidden = false)
	private String inqueryType;
	@ApiModelProperty(required = true, value = "제목", example = "제목", hidden = false)
	private String title;
	@ApiModelProperty(required = true, value = "내용", example = "내용", hidden = false)
	private String content;
	private LocalDate workDate;
	private String replyContent; // 답변글
	private LocalDate replyWorkDate;// 답변글 작성일자
	private String replyYn;
	private Long boardId;

}
