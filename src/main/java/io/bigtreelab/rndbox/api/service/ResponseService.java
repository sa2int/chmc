package io.bigtreelab.rndbox.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import io.bigtreelab.rndbox.api.response.CommonResult;
import io.bigtreelab.rndbox.api.response.ResponseResult;

@Service
public class ResponseService {

	@Autowired
	private MessageSource messageSource;

	// enum으로 api 요청 결과에 대한 code, message를 정의합니다.
	public enum CommonResponse {
		SUCCESS(0, "성공하였습니다.");

		int code;
		String msg;

		CommonResponse(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public int getCode() {
			return code;
		}

		public String getMsg() {
			return msg;
		}
	}

	/**
	 * 단일건 결과를 처리하는 메소드
	 *
	 * @param <T>
	 * @param data
	 * @return
	 */
	public <T> ResponseResult<T> getResponseResult(T data) {
		ResponseResult<T> result = new ResponseResult<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}

	/**
	 * 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
	 *
	 * @param result
	 */
	private void setSuccessResult(CommonResult result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(messageSource.getMessage("success.msg", null, LocaleContextHolder.getLocale()));
	}

	/**
	 * 실패 결과만 처리하는 메소드
	 *
	 * @param result
	 */
	public CommonResult getFailResult(int code, String msg) {
		CommonResult result = new CommonResult();
		result.setSuccess(false);
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

	// 성공 결과만 처리하는 메소드
	public CommonResult getSuccessResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}

	/**
	 * 결과 모델에 api 요청 밸리데이션 오류 데이터를 세팅해주는 메소드
	 *
	 * @param <T>
	 * @param data : validation 항목과 메세지
	 * @param code : 400
	 * @param msg  : bad request
	 * @return
	 */
	public <T> ResponseResult<T> getFailResult(T data, int code, String msg) {
		ResponseResult<T> result = new ResponseResult<>();
		result.setSuccess(false);
		result.setData(data);
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

}
