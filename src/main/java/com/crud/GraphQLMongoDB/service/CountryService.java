package com.crud.GraphQLMongoDB.service;

import java.util.List;

import com.crud.GraphQLMongoDB.model.Country;


public interface CountryService {
	
	List<Country> getAllCountries();
	
	Country validateAndGetCountryById(String id);
	
	Country saveCountry(Country country);
	
	boolean deleteCountry(Country country);
	
	Country validateAndGetCountryByCountryCode(String countryCode);
	
}
