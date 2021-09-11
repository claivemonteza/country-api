package com.application.repository.query;

import com.application.model.Country;


/**
 * @author Claive Monteza
 * 
 * @version 1.0
 * @since 1.8
 */

public interface CountryRepositoryQuery {

	public Country findByName(String name);
}
