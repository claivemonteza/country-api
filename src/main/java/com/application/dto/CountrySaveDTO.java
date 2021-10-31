package com.application.dto;

import com.application.model.Country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountrySaveDTO {
	
	private String name;
	private String capital;
	private String region;
	private String subregion;
	private double area;
	
	public Country toEntity() {
		return new Country(null, name, capital, region, subregion, area);
	}
}
