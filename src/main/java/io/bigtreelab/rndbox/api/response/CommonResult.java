package io.bigtreelab.rndbox.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    @ApiModelProperty(value = "응답 성공 여부: T/F")
    private boolean success;

    @ApiModelProperty(value = "응답 코드: >= 0 정상, < 0 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;
    

	public void setSuccess(boolean b) {
		this.success = b;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
