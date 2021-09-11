package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Country;
import com.application.repository.CountryRepository;


/**
 * @author Claive Monteza
 * 
 * @version 1.0
 * @since 1.8
 */

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	

	public Country addCountry(Country country) {
		return countryRepository.save(country);
	}

	public Country updateCountry(Country country) {
		return countryRepository.save(country);
	}

	public void deleteCountry(Long id) {
		countryRepository.deleteById(id);
	}

	public Country findCountryByName(String name) {
		return countryRepository.findByName(name);
	}

	public List<Country> allCountries() {
		return countryRepository.findAll();
	}
}
