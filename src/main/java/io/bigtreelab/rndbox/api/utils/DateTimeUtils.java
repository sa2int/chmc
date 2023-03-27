package io.bigtreelab.rndbox.api.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
	public static LocalDateTime nowFromZone() {
		return ZonedDateTime.now().withNano(0).toLocalDateTime();
	}

	public static LocalDate nowDateFromZone() {
		return ZonedDateTime.now().withNano(0).toLocalDate();
	}

	public static String nowFromZone(String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return ZonedDateTime.now().withNano(0).toLocalDateTime().format(formatter);
	}

	/**
	 * 인벤토리 저장 예약 시간 현재시간에서 분과초를 59분 59초로 설정
	 * 
	 * @return
	 */
	public static LocalDateTime storageDateTimeFromZone() {
		LocalDateTime dateTime = ZonedDateTime.now().withNano(0).toLocalDateTime();
		return LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), dateTime.getHour(),
				59, 59, 0);
	}

	public static String storageDateTimeFromZoneWithFormat() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");
		LocalDateTime dateTime = ZonedDateTime.now().withNano(0).toLocalDateTime();
		return LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth(), dateTime.getHour(),
				59, 59, 0).format(formatter);
	}
}
