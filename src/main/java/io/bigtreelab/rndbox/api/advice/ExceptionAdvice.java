package io.bigtreelab.rndbox.api.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import io.bigtreelab.rndbox.api.advice.exception.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import io.bigtreelab.rndbox.api.response.CommonResult;
import io.bigtreelab.rndbox.api.response.ResponseResult;
import io.bigtreelab.rndbox.api.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

	private final ResponseService responseService;
	private final MessageSource messageSource;

	private String getMessage(String code) {
		return getMessage(code, null);
	}

	private String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}

	/***
	 * -9999
	 * default Exception
	 */
//	@ExceptionHandler(Exception.class)
//	// @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ResponseStatus(HttpStatus.OK)
//	protected CommonResult defaultException(HttpServletRequest request, Exception e) {
//		log.info(String.valueOf(e));
//		return responseService.getFailResult
//				(Integer.parseInt(getMessage("unKnown.code")), getMessage("unKnown.msg"));
//	}

	/***
	 * -1000
	 * 유저를 찾지 못했을 때 발생시키는 예외
	 */
	@ExceptionHandler(CUserNotFoundException.class)
	@ResponseStatus(HttpStatus.OK)
	protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
		return responseService.getFailResult(
				Integer.parseInt(getMessage("userNotFound.code")), getMessage("userNotFound.msg")
		);
	}

	/**
	 * -1003
	 * 전달한 Jwt 이 정상적이지 않은 경우 발생 시키는 예외
	 */
	@ExceptionHandler(CAuthenticationEntryPointException.class)
	// @ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseStatus(HttpStatus.OK)
	protected CommonResult authenticationEntrypointException(HttpServletRequest request, CAuthenticationEntryPointException e) {
		log.error(getMessage("authenticationEntrypoint.msg"));
		return responseService.getFailResult(
				Integer.parseInt(getMessage("authenticationEntrypoint.code")), getMessage("authenticationEntrypoint.msg")
		);
	}

	/**
	 * -1005
	 * refresh token 에러시 발생 시키는 에러
	 */
	@ExceptionHandler(CRefreshTokenException.class)
	// @ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseStatus(HttpStatus.OK)
	protected CommonResult refreshTokenException(HttpServletRequest request, CRefreshTokenException e) {
		log.error(getMessage("refreshTokenInValid.msg"));
		return responseService.getFailResult(
				Integer.parseInt(getMessage("refreshTokenInValid.code")), getMessage("refreshTokenInValid.msg")
		);
	}

	/***
	 * -1010 소셜 로그인 시 필수 동의항목 미동의시 에러
	 */
	@ExceptionHandler(CUserCellphoneNoParamException.class)
	@ResponseStatus(HttpStatus.OK)
	protected CommonResult socialAgreementException(HttpServletRequest request, CUserCellphoneNoParamException e) {
		log.error(getMessage("userCellphoneNoParamException.msg"));
		return responseService.getFailResult(Integer.parseInt(getMessage("userCellphoneNoParamException.code")),
				getMessage("userCellphoneNoParamException.msg"));
	}

	/**
	 * validation 오류 작업
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseStatus(HttpStatus.OK)
	public ResponseResult<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors()
				.forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
		log.error(getMessage("badRequest.msg"));
		return responseService.getFailResult(errors, Integer.parseInt(getMessage("badRequest.code")), getMessage("badRequest.msg"));
	}

	@ExceptionHandler(ConstraintViolationException.class)
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseStatus(HttpStatus.OK)
	public ResponseResult<List<String>> handleConstraintViolation(ConstraintViolationException  ex, WebRequest request){
		List<String> errors = ex.getConstraintViolations()
				.parallelStream()
				.map(e -> e.getMessage())
				.collect(Collectors.toList());
		log.error(getMessage("badRequest.msg"));
		return responseService.getFailResult(errors, Integer.parseInt(getMessage("badRequest.code")), getMessage("badRequest.msg"));
	}

	/***
	 * -1020 이미 가입된 계정이 있습니다. 정확한 위챗아이디를 입력 해주세요
	 */
	@ExceptionHandler(CWechatUserExistException.class)
	// @ResponseStatus(HttpStatus.CONFLICT)
	@ResponseStatus(HttpStatus.OK)
	protected CommonResult wechatUserExistException(HttpServletRequest request, CWechatUserExistException e) {
		log.error(getMessage("wechatUserExistException.msg"));
		return responseService.getFailResult(Integer.parseInt(getMessage("wechatUserExistException.code")),
				getMessage("wechatUserExistException.msg"));
	}

	/** BanUser
	 * c-1011 Ban 유저 입니다..
	 */
	@ExceptionHandler(CBanException.class)
	@ResponseStatus(HttpStatus.OK)
	protected CommonResult banException(HttpServletRequest request, CBanException e) {
		log.error(getMessage("thisIsBanUser.msg"));
		return responseService.getFailResult(Integer.parseInt(getMessage("thisIsBanUser.code")),
				getMessage("thisIsBanUser.msg"));
	}

}
