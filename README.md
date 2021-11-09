# Country API

This project is a country restful api which contains 7 endpoints that allows for :
- Creating new countires
- Updating existing countries
- Deleting existing countries
- Fetching country by ID
- Fetching country by name
- Viewing a sorted list of all countries
- Viewing a list of all countries

## Specifications

### Project Type
This is a spring based project making use of the springboot framework

### Build automation tools
This project makes use of maven as its build automation tool

### Demo
https://restcountries-91e47.firebaseapp.com/

## API
The API base URL is https://country-api-restful.herokuapp.com/ and can be used to access the following endpoints :

### Add Country (POST)
- endpoint - /restcountries/v1/countries/save

### Update Country (PUT)
- endpoint - /restcountries/v1/countries/update/{id}

### Delete Country (DELETE)
- endpoint - /restcountries/v1/countries/delete/{id}

### Fetch Country By Id (GET)
- endpoint - /restcountries/v1/countries

### Fetch Country By Name (GET)
- endpoint - /restcountries/v1/countries/find/{name}

### Sorted Countries By Properties (GET)
- endpoint - /restcountries/v1/countries/sortedBy/{property}

### All Countries (GET)
- endpoint - /restcountries/v1/countries

