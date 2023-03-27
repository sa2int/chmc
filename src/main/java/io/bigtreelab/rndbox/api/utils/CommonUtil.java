package io.bigtreelab.rndbox.api.utils;


import io.bigtreelab.rndbox.api.advice.exception.CAuthenticationEntryPointException;
import io.bigtreelab.rndbox.api.dto.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

public class CommonUtil {

	@Autowired
	MessageSource messageSource;

	/**
	 * Object type 변수가 비어있는지 체크
	 * 
	 * @param obj
	 * @return Boolean : true / false
	 */
    public static Boolean empty(Object obj) {
        if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
        else if (obj instanceof List) return obj == null || ((List<?>) obj).isEmpty();
        else if (obj instanceof Map) return obj == null || ((Map<?, ?>) obj).isEmpty();
        else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
        else return obj == null;
    }
 
    /**
     * Object type 변수가 비어있지 않은지 체크
     * 
     * @param obj
     * @return Boolean : true / false
     */
    public static Boolean notEmpty(Object obj) {
        return !empty(obj);
    }
    
    // Long 타입의 두 객체가 같은지를 체크하는 함수
    public static boolean isEqual(Long value1, Long value2) {
        if(value1 == null || value2 == null) return false;
        if(value1.compareTo(value2) == 0) return true;
        return false;
    }

    /** 
     *  SecurityContext에서 인증받은 회원의 정보를 얻어온다.
     */
    public static Long getUserNoByAuthentication() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication.getName().equals("anonymousUser")) {
			throw new CAuthenticationEntryPointException();
		}

        return Long.parseLong(authentication.getName());
    }

	/**
	 * 배타적 시간 계산
	 */
	public static Integer makeValidityDateSeconds(LocalDateTime validityDate) {

		if (ObjectUtils.isEmpty(validityDate))
			return 0;
		if (validityDate.isBefore(DateTimeUtils.nowFromZone()))
			return 0;
		return (int) ChronoUnit.SECONDS.between(DateTimeUtils.nowFromZone(), validityDate);
	}

	/**
	 * 두날짜 사이의 차를 날짜 문자열로 받음
	 */
	public static String makeSecondsToDateTimeString(LocalDateTime validityDate) {
		return makeSecondsToDdHiMmSsString(makeValidityDateSeconds(validityDate));
	}

	/**
	 * 시간을 입력받안 날짜 문장열로 반환
	 */
	public static String makeSecondsToDdHiMmSsString(Integer seconds) {

		int day = seconds / (60 * 60 * 24);
		int hour = (seconds - (day * 60 * 60 * 24)) / (60 * 60);
		int min = (seconds - (day * 60 * 60 * 24) - (hour * 60 * 60)) / (60);
		int sec = seconds % 60;
		
		return String.format("%d : %d : %d : %d", day, hour, min, sec);
	}

	/**
	 * 두날짜 사이의 차를 날짜 문자열로 받음
	 */
	public static Integer makeSecondsToDays(LocalDateTime validityDate) {
		return makeSecondsToDays(makeValidityDateSeconds(validityDate));
	}

	/**
	 * 시간을 입력받안 날짜 문장열로 반환
	 */
	public static Integer makeSecondsToDays(Integer seconds) {
		return seconds / (60 * 60 * 24);
	}

	// 숫자를 문자로 전환한다.
	public String extractNumber(String str) {
		return str.replaceAll("[^\\d]", "");
	}

	//메시지 보내기
	public ResponseMsg getMsg(String message, HttpServletRequest request, Object MapData) {
		ResponseMsg msg = new ResponseMsg();
		msg.setCode(messageSource.getMessage(message + ".code", null, LocaleContextHolder.getLocale()));
		msg.setMsg(messageSource.getMessage(message + ".msg", null, LocaleContextHolder.getLocale()));
		if (MapData != null) {
			msg.setData(MapData);
		}
		msg.setInstance(request.getRequestURI());

		return msg;
	}

}
