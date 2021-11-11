package com.application.controller.modifier;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import static com.application.constant.DateConstants.DATE_TIME_FORMAT;

public class DateTimeSerializer extends StdSerializer<Date> {
	
	private static final long serialVersionUID = 1L;

	private final SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);

	public DateTimeSerializer() {
		this(null);
	}

	protected DateTimeSerializer(Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(formatter.format(value));
	}
	
	

}
