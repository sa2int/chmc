package io.bigtreelab.rndbox.api.controller.v1;

import io.bigtreelab.rndbox.api.dto.EnumValueDto;
import io.bigtreelab.rndbox.api.enums.EnumMapper;
import io.bigtreelab.rndbox.api.response.CommonResult;
import io.bigtreelab.rndbox.api.response.ResponseResult;
import io.bigtreelab.rndbox.api.service.ResponseService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Configuration
@Api(tags = {"9. Common"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class CommonController {
	
	private final EnumMapper enumMapper;
	private final ResponseService responseService;
   
	@ApiOperation(value = "공통코드를  검색", notes = "공통코드를 조회합니다. 첫글자는 소문자, 여러건을 검색시 콤마로 구분합니다. 예)PaymentMethod,JoinType")
    @GetMapping("/common/code/{codeMajor}")
    @ApiImplicitParams({
        @ApiImplicitParam(
                name = "X-AUTH-TOKEN",
                value = "로그인 성공 후 AccessToken",
                required = true, dataType = "String", paramType = "header")
    })
    public ResponseResult<Map<String, List<EnumValueDto>>> getEnum(
			@ApiParam(value = "공통코드", example = "SortType, PaymentMethod", required = true) 
    		@PathVariable String codeMajor) 
    {
        return responseService.getResponseResult(enumMapper.get(codeMajor)); 
    }


    //alb접속 url
    @GetMapping("/poking")
    public CommonResult getListByBrand() {
        return responseService.getSuccessResult();
    }


}
	 