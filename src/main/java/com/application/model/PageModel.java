package com.application.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class PageModel<T> {
	
	private Long total;
	private int currentPage;
	private int numPages;
	private int pageSize;
	private List<T> elements;
	
}
