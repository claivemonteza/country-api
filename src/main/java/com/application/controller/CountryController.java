package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value="/countries")
@CrossOrigin(origins = "*")
public class CountryController{

	@Autowired
	private CountryService countryService;


    @PostMapping(value="/save")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){
        Country newCountry = countryService.addCountry(country);
        return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
    }

    @PutMapping(value="/update")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country){
        Country updateCountry = countryService.updateCountry(country);
        return new ResponseEntity<>(updateCountry, HttpStatus.OK);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id){
       countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/find/{name}")
    public ResponseEntity<Country> findCountryByName(@PathVariable("name") String name){
        Country country = countryService.findCountryByName(name);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries(){
        List<Country> countries = countryService.allCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
