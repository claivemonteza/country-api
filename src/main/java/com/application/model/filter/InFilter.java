package com.application.model.filter;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class InFilter {
	private String column;
	private List<String> values;
}
