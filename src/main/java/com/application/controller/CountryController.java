package com.application.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.domain.Country;
import com.application.dto.CountryEditDTO;
import com.application.dto.CountrySaveDTO;
import com.application.service.CountryService;

import io.swagger.annotations.ApiOperation;


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
	@ApiOperation("Show a list")
	public List<Country> all() {
		return countryService.list();
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Country> save(@RequestBody CountrySaveDTO dto) {
		Country newCountry = countryService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(newCountry);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Country> edit(@Valid @RequestBody CountryEditDTO dto, @PathVariable("id") Long id) {
		Country updateCountry = countryService.edit(dto.toEntity(id));
		return ResponseEntity.status(HttpStatus.OK).body(updateCountry);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		countryService.delete(id);
	}

	
	@GetMapping(value = "/find/{id}")
	public Country findById(@PathVariable("id") Long id) {
		return countryService.get(id);
	}
	
	@GetMapping(value = "/findByName/{name}")
	public Country findByName(@PathVariable("name") String name) {
		return countryService.findCountryByName(name);
	}
	
	
	@GetMapping("/sortedBy/{property}")
	public ResponseEntity<List<Country>> fetchCountriesSortedByProperties(@PathVariable("property") String property) {

        List<Country> result = countryService.findAndSortAllByProperty(property);
        return !result.isEmpty() ?
                ResponseEntity.status(HttpStatus.FOUND).body(countryService.findAndSortAllByProperty(property)) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(countryService.findAndSortAllByProperty(property));
    }
}
