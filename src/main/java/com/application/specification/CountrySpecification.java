package com.application.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.application.domain.Country;

public class CountrySpecification {

	public static Specification<Country> search(String text) {
		return new Specification<Country>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (text == null || text.trim().length() <= 0)
					return null;

				String pattern = "%" + text + "%";

				Predicate identifierOrDescriptionOrYear = cb.or(
						cb.or(cb.or(cb.like(root.get("name"), pattern),
								cb.like(root.get("capital"), pattern)),
								cb.like(root.get("region").as(String.class), pattern)),
						cb.like(root.get("subregion"), pattern));

				return identifierOrDescriptionOrYear;
			}

		};
	}
}
