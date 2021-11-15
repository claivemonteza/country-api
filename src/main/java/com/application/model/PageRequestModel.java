package com.application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.application.model.filter.InFilter;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageRequestModel {
	private int limit = 15;
	private int page = 0;
	private String sort = ""; // default example: sort=id,-name (id asc, name desc)
	private String search = "";
	private String filters = "";
	private String inFilters = "";
	
	public PageRequestModel(Map<String, String> params) {
		if(params.containsKey("limit")) limit = Integer.valueOf(params.get("limit"));
		if(params.containsKey("page")) page = Integer.valueOf(params.get("page"));
		if(params.containsKey("sort")) sort = String.valueOf(params.get("sort"));
		if(params.containsKey("search")) search = String.valueOf(params.get("search"));
		if(params.containsKey("filters")) filters = String.valueOf(params.get("filters"));
		if(params.containsKey("in_filters")) inFilters = String.valueOf(params.get("in_filters"));

	}
	
	public PageRequest toPageRequest() {
		List<Order> orders = new ArrayList<>();

		String[] properties = sort.split(",");

		for (String prop : properties) {

			System.out.println(prop);

			if (prop.trim().length() > 0) {
				String column = "";

				if (prop.startsWith("-")) {
					column = prop.replace("-", "").trim();

					orders.add(Order.desc(column));
				}

				else {
					column = prop.trim();
					orders.add(Order.asc(column));
				}

			}
		}
		return PageRequest.of(page, limit, Sort.by(orders));
	}
	
	
	public List<InFilter> getInFilters() {
		List<InFilter> listFilters = new ArrayList<>();
		if (inFilters == null || inFilters.trim().length() <= 0)
			return listFilters;
		String[] filtersParam = inFilters.split(";");
		for(String filter : filtersParam) {
			if(filter.contains(":")) {
				String[] subFilters = filter.split(":");
				if (subFilters.length == 2) {
					String column = subFilters[0].trim();
					String[] values = subFilters[1].trim().split(",");
					
					if(values.length > 0)
					{
						listFilters.add(new InFilter(column, Arrays.asList(values)));
					}
				}
			}
		}
		return listFilters;
	}

}
