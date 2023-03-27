package io.bigtreelab.rndbox.api.controller.v1;

import io.bigtreelab.rndbox.api.dto.Category.CategoryDto;
import io.bigtreelab.rndbox.api.dto.ResponseMsg;
import io.bigtreelab.rndbox.api.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Api(tags = {"1. Category"}, value = "카테고리")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    MessageSource messageSource;

    @ApiOperation(value = "박스 리스트 조회")
    @GetMapping("/category")
    public ResponseEntity<ResponseMsg> getAllBox(
            HttpServletRequest request) {
        ResponseMsg msg = new ResponseMsg();

        List<CategoryDto.CategoryResponse> category = categoryService.getCategoryList();

        msg.setCode(messageSource.getMessage("reqSuccess.code", null, LocaleContextHolder.getLocale()));
        msg.setMsg(messageSource.getMessage("reqSuccess.msg", null, LocaleContextHolder.getLocale()));
        msg.setData(category);
        msg.setInstance(request.getRequestURI());

//        msg = getMsg("reqSuccess", request, boxCodeList);
//        msg.setInstance(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }



}
