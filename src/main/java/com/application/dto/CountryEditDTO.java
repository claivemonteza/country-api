package com.application.dto;

import com.application.domain.Country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryEditDTO {
	
	private String name;
	private String capital;
	private String region;
	private String subregion;
	private double area;
	
	public Country toEntity(Long id) {
		return new Country(id, name, capital, region, subregion, area);
	}
}
