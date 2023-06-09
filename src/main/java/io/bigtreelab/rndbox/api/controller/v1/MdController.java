package io.bigtreelab.rndbox.api.controller.v1;


import io.bigtreelab.rndbox.api.dto.ResponseMsg;

import io.bigtreelab.rndbox.api.dto.md.*;

import io.bigtreelab.rndbox.api.service.ClosetService;
import io.bigtreelab.rndbox.api.service.MdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

@Api(tags = {"1. MD"}, value = "MD")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MdController {

    private final MdService mdService;
    private final ClosetService closetService;

    @Autowired
    MessageSource messageSource;

    @ApiOperation(value = "리스트 등록")
    @PostMapping("/md/post")
    public ResponseEntity<ResponseMsg> postMd(@RequestBody MdDto.MdRequest mdRequest,
                                              HttpServletRequest request) throws IOException {
        ResponseMsg msg = new ResponseMsg();
        MdDto.Response menu =  mdService.saveMenu(mdRequest);

        msg.setCode(messageSource.getMessage("reqSuccess.code", null, LocaleContextHolder.getLocale()));
        msg.setMsg(messageSource.getMessage("reqSuccess.msg", null, LocaleContextHolder.getLocale()));
        msg.setData(menu);
        msg.setInstance(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @ApiOperation(value = "옷 추천")
    @PostMapping("/md/cody/post")
    public ResponseEntity<ResponseMsg> postMdCody(@RequestBody MdCodyRequestDto mdRequest,
                                              HttpServletRequest request) throws IOException {
        ResponseMsg msg = new ResponseMsg();
        MdResponseDto menu =  mdService.saveMdCody(mdRequest);

        msg.setCode(messageSource.getMessage("reqSuccess.code", null, LocaleContextHolder.getLocale()));
        msg.setMsg(messageSource.getMessage("reqSuccess.msg", null, LocaleContextHolder.getLocale()));
        msg.setData(menu);
        msg.setInstance(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @ApiOperation(value = "박스 리스트 조회")
    @GetMapping("/md")
    public ResponseEntity<ResponseMsg> getAllBox(
            HttpServletRequest request) {
        ResponseMsg msg = new ResponseMsg();

        List<MdQueryDslDto> category = mdService.getMdList();

        msg.setCode(messageSource.getMessage("reqSuccess.code", null, LocaleContextHolder.getLocale()));
        msg.setMsg(messageSource.getMessage("reqSuccess.msg", null, LocaleContextHolder.getLocale()));
        msg.setData(category);
        msg.setInstance(request.getRequestURI());

//        msg = getMsg("reqSuccess", request, boxCodeList);
//        msg.setInstance(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @ApiOperation(value = "옷 매칭")
    @PostMapping("/md/choice/post")
    public ResponseEntity<ResponseMsg> postMdChoice(@RequestBody MdChoiceDto.MdChoiceRequest mdChoiceRequest,
                                              HttpServletRequest request) {
        ResponseMsg msg = new ResponseMsg();
        MdChoiceDto.Response menu =  mdService.saveMdChoice(mdChoiceRequest);

        msg.setCode(messageSource.getMessage("reqSuccess.code", null, LocaleContextHolder.getLocale()));
        msg.setMsg(messageSource.getMessage("reqSuccess.msg", null, LocaleContextHolder.getLocale()));
        msg.setData(menu);
        msg.setInstance(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @ApiOperation(value = "매칭 조회")
    @GetMapping("/md/choice/{id}")
    public ResponseEntity<ResponseMsg> getMdChoice(
            @ApiParam(value = "휴대폰번호", example = "1", required = true) @PathVariable String id,
            HttpServletRequest request) {
        ResponseMsg msg = new ResponseMsg();

        List<MdChoiceDto.Response> closet = closetService.getMdChoice(id);

        msg.setCode(messageSource.getMessage("reqSuccess.code", null, LocaleContextHolder.getLocale()));
        msg.setMsg(messageSource.getMessage("reqSuccess.msg", null, LocaleContextHolder.getLocale()));
        msg.setData(closet);
        msg.setInstance(request.getRequestURI());

//        msg = getMsg("reqSuccess", request, boxCodeList);
//        msg.setInstance(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}
