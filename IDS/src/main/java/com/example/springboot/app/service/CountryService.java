package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Country;

public interface CountryService {
	
	Country createCountry(Country country);

	Country updateCountry(Country country);
	
	List<Country> getAllCountry(); 

	Country getCountryById(long countryId); 

	void deleteCountry(long id);

}
