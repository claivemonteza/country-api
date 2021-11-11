package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.domain.Country;
import com.application.repository.query.CountryRepositoryQuery;


/**
 * @author Claive Monteza
 *
 * @version 1.0
 * @since 1.8
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>, CountryRepositoryQuery{
	
	Country findByName(String name);
}
