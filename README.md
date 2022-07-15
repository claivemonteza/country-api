# 🌎 Country API

<p align="center">
  <a href="#technologies">🛠️ Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#api">🌐 API</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#demo">🚀 Demo</a>
</p>

This project is a country restful api which contains 7 endpoints that allows for :
- Creating new countires
- Updating existing countries
- Deleting existing countries
- Fetching country by ID
- Fetching country by name
- Viewing a sorted list of all countries
- Viewing a list of all countries

<div align="center">
  <img alt="image" src="https://raw.githubusercontent.com/claivemonteza/country-api/main/image.png">
</div>

## Author
[Claive Monteza](https://www.linkedin.com/in/claive-monteza-1b157a149/)

## Technologies
- Spring Boot
- Maven
- Java



## API
The API base URL is https://country-api-restful.herokuapp.com/ and can be used to access the following endpoints :

### Add Country (POST)
- endpoint -```/restcountries/v1/countries/save```

### Update Country (PUT)
- endpoint -```/restcountries/v1/countries/update/{id}```

### Delete Country (DELETE)
- endpoint -```/restcountries/v1/countries/delete/{id}```

### Fetch Country By Id (GET)
- endpoint - ```/restcountries/v1/countries```

### Fetch Country By Name (GET)
- endpoint -```/restcountries/v1/countries/find/{name}```

### Sorted Countries By Properties (GET)
- endpoint -```/restcountries/v1/countries/sortedBy/{property}```

### All Countries (GET)
- endpoint -```/restcountries/v1/countries```

## Demo
https://restcountries-a2ea5.firebaseapp.com/

