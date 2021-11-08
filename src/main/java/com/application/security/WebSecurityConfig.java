package com.application.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.cors()
	            .and().authorizeRequests()
	            .anyRequest().permitAll()
	            .and().csrf().disable();
	}
	
	@Bean
	protected CorsConfigurationSource corsConfigurationSource() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	    return source;
	}

//	@Bean
//	public CorsFilter corsFilter() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
//				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//		corsConfiguration.setAllowCredentials(true);
//		
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfiguration.applyPermitDefaultValues());
//		return new CorsFilter(source);
//	}
}