package io.bigtreelab.rndbox.api.dto.user;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @ApiModelProperty(required = true, value = "이름", example = "홍길동")
    private String name; 
    
	@ApiModelProperty(required = false, value = "유저번호", example = "abc@email.com")
	private Long userNo;
}	
