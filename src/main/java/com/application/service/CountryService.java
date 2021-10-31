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
public class CountryService implements IService<Country>{

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country save(Country t){
		return countryRepository.save(t);
	}

	@Override
	public Country edit(Country t) {
		return countryRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		countryRepository.deleteById(id);
	}

	@Override
	public Country get(Long t) {
		return countryRepository.findById(t).get();
	}

	@Override
	public List<Country> list() {
		return countryRepository.findAll();
	}
	
	public Country findCountryByName(String name) {
		return countryRepository.findByName(name);
	}
	
}
