package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.CountryEditDTO;
import com.application.dto.CountrySaveDTO;
import com.application.model.Country;
import com.application.service.CountryService;


/**
 * @author Claive Monteza
 *
 *
 * @version 1.0
 * @since 1.8
 */

@RestController
@RequestMapping(value="restcountries/v1/countries")
public class CountryController{

	@Autowired
	private CountryService countryService;


	@GetMapping
	public List<Country> all() {
		return this.countryService.list();
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Country> save(@RequestBody CountrySaveDTO dto) {
		Country newCountry = this.countryService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(newCountry);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Country> edit(@RequestBody CountryEditDTO dto, @PathVariable("id") Long id) {
		Country updateCountry = this.countryService.edit(dto.toEntity(id));
		return ResponseEntity.status(HttpStatus.OK).body(updateCountry);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.countryService.delete(id);
	}

	@GetMapping(value = "/find/{name}")
	public Country findByName(@PathVariable("name") String name) {
		return this.countryService.findCountryByName(name);
	}
}
