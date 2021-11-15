package com.application.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.application.domain.Country;
import com.application.repository.query.CountryRepositoryQuery;


/**
 * @author Claive Monteza
 * 
 * @version 1.0
 * @since 1.8
 */

public class ContryRepositoryImpl implements CountryRepositoryQuery{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Country findByName(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
		Root<Country> root = criteria.from(Country.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("name"),name));
		TypedQuery<Country> query = entityManager.createQuery(criteria);
		return query.getSingleResult() ;
	}

}
