package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.application.domain.Country;
import com.application.model.PageModel;
import com.application.model.PageRequestModel;
import com.application.repository.CountryRepository;
import com.application.specification.CountrySpecification;

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

	public Country save(Country t) {
		return countryRepository.save(t);

	}

	public Country edit(Country t) {
		if (t.getId() == null) {
			return null;
		}
		return countryRepository.save(t);
	}

	public void delete(Long id) {
		countryRepository.deleteById(id);
	}

	public Country get(Long t) {
		return countryRepository.findById(t)
				.orElseThrow(() -> new EmptyResultDataAccessException("Country not found", 1));
	}

	public PageModel<Country> list(PageRequestModel p) {
		Specification<Country> spec = CountrySpecification.search("");
		Page<Country> page = countryRepository.findAll(spec, p.toPageRequest());
		PageModel<Country> pm = new PageModel<>(page.getTotalElements(), page.getNumber(), page.getTotalPages(),
				page.getSize(), page.getContent());
		return pm;
	}

	public Country findCountryByName(String name) {
		return countryRepository.findByName(name);
	}

	public List<Country> findAndSortAllByProperty(String property) {
		return countryRepository.findAll(Sort.by(property));
	}

}
