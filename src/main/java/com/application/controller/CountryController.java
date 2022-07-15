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
import com.application.dto.CountryDTO;
import com.application.service.CountryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



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


	@Operation(summary="Get countries", description="Get a list of countries",tags="Get")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="List of countries"),
			@ApiResponse(responseCode = "404", description="Not found")
	})
	@GetMapping
	public List<Country> all() {
		return countryService.list();
	}

	@Operation(summary="Save country", description="Will save country",tags="Post")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", description="Save country"),
			@ApiResponse(responseCode = "400", description="Duplicate country")
	})
	@PostMapping(value = "/save")
	public ResponseEntity<Country> save(@RequestBody CountryDTO dto) {
		Country newCountry = countryService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(newCountry);
	}

	@Operation(summary="Update country", description="Will update country",tags="Put")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="Update country"),
			@ApiResponse(responseCode = "400", description="Bad Request")
	})
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Country> edit(@Valid @RequestBody CountryDTO dto, @PathVariable("id") Long id) {
		Country updateCountry = countryService.edit(dto.toEntity(id));
		return ResponseEntity.status(HttpStatus.OK).body(updateCountry);
	}

	@Operation(summary="Delete country", description="Will remove country",tags="Delete")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "204", description="Delete country with id."),
			@ApiResponse(responseCode = "400", description="Does not exist country with this id.")
	})
	@DeleteMapping(value = "/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		countryService.delete(id);
	}

	
	@Operation(summary="Find country", description="Will search country",tags="Get")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="search country that have id"),
			@ApiResponse(responseCode = "400", description="Did find country with this id")
	})
	@GetMapping(value = "/find/{id}")
	public Country findById(@PathVariable("id") Long id) {
		return countryService.get(id);
	}
	
	
	@Operation(summary="Find country by name", description="Will search country",tags="Get")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="search country that have id"),
			@ApiResponse(responseCode = "400", description="Did find country with this id")
	})
	@GetMapping(value = "/findByName/{name}")
	public Country findByName(@PathVariable("name") String name) {
		return countryService.findCountryByName(name);
	}
	
	@Operation(summary="Sorted country by region", description="Will search country by the region",tags="Get")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "302", description="Show list of countries of region"),
			@ApiResponse(responseCode = "400", description="Did find any country, so list all countries")
	})
	@GetMapping("/sortedBy/{property}")
	public ResponseEntity<List<Country>> fetchCountriesSortedByProperties(@PathVariable("property") String property) {

        List<Country> result = countryService.findAndSortAllByProperty(property);
        return !result.isEmpty() ?
                ResponseEntity.status(HttpStatus.FOUND).body(countryService.findAndSortAllByProperty(property)) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(countryService.findAndSortAllByProperty(property));
    }
}
