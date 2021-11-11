package com.application.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.application.controller.modifier.DateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ApiErrorModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int statusCode;
	private List<String> messages;
	
	@JsonSerialize(using = DateTimeSerializer.class)
	private Date occuredAt;
}
