package io.bigtreelab.rndbox.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class CommonCodeDto {

	@ApiModelProperty(required = true, value = "공통코드", example = "스트링",  hidden=false)
	private String code;
	
	@ApiModelProperty(required = true, value = "공통코드값", example = "스트링",  hidden=false)
	private String value;
	
	
}
