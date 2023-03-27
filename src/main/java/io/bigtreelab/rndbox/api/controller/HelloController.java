package io.bigtreelab.rndbox.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.bigtreelab.rndbox.api.dto.EnumValueDto;
import io.bigtreelab.rndbox.api.enums.EnumMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

	@Autowired
    MessageSource messageSource;

	@Autowired
	EnumMapper enumMapper;

    @GetMapping(value="/hello")
    @ResponseBody
    public String helloworldString() {
        return messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale());
    }

    @GetMapping(value="/hello/string2")
    @ResponseBody
    public String helloworldString2() throws NoSuchAlgorithmException {

        Random random = new Random();
        int aa = random.nextInt(3)+1;
        int bb = aa+1;
        System.out.println("aa:"+aa);
        System.out.println("bb:"+bb);
        return "Hello World2...";
    }

    @PostMapping("/hello/enumTest")
    @ApiImplicitParams({
        @ApiImplicitParam(
                name = "X-AUTH-TOKEN",
                value = "로그인 성공 후 AccessToken",
                required = true, dataType = "String", paramType = "header")
    })
    public Map<String, List<EnumValueDto>> getEnum() {
        return enumMapper.get("joinType");
    }


}
