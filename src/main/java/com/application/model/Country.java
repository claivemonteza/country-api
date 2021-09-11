package com.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Claive Monteza
 *
 * @version 1.0
 * @since 1.8
 */

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "capital", nullable = false)
	private String capital;
	
	@Column(name = "region", nullable = false)
	private String region;
	
	@Column(name = "subregion", nullable = false)
	private String subregion;
	
	@Column(name = "area", nullable = false)
	private double area;
}
