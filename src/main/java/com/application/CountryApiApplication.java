package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Country API REST", version = "1.0", description = "Get information about countries via a RESTful API", 
contact=@Contact(name="Claive Monteza", url="https://claivemonteza.github.io/portfolio-v1/", email="claivemonteza@gmail.com"),
license=@License(name="Apache 2.0",url="https://www.apache.org/licenses/LICENSE-2.0")))

public class CountryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryApiApplication.class, args);
	}

}
