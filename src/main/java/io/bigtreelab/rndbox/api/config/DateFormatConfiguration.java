package io.bigtreelab.rndbox.api.config;

import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import io.bigtreelab.rndbox.api.utils.Constants;

@Configuration
public class DateFormatConfiguration {
	private static final String dateFormat = "yyyy-MM-dd";
	private static final String datetimeFormat = "yyyy-MM-dd HH:mm:ss";

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		return jacksonObjectMapperBuilder -> {
			jacksonObjectMapperBuilder.timeZone(TimeZone.getTimeZone(Constants.TIME_ZONE_BASE_STRING));
			jacksonObjectMapperBuilder.simpleDateFormat(datetimeFormat);
			jacksonObjectMapperBuilder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
			jacksonObjectMapperBuilder
					.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(datetimeFormat)));
		};
	}
}
