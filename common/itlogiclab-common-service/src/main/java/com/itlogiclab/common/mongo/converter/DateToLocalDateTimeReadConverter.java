package com.itlogiclab.common.mongo.converter;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import org.springframework.core.convert.converter.Converter;

public class DateToLocalDateTimeReadConverter implements Converter<Date, LocalDateTime> {

	
	@Override
	public LocalDateTime convert(Date source) {
		LocalDateTime datetime = null;
		if(Objects.nonNull(source)) {
			datetime = Instant.ofEpochMilli(source.getTime()).atZone(ZoneId.of("UTC")).toLocalDateTime();
		}
		
		return datetime;
	}
	
}
