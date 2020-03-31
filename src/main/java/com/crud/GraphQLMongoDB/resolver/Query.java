package com.crud.GraphQLMongoDB.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.crud.GraphQLMongoDB.model.Country;
import com.crud.GraphQLMongoDB.service.CountryService;

@Component
public class Query implements GraphQLQueryResolver{
	
	private CountryService countryService;
	
	public Query(CountryService countryService) {
		this.countryService = countryService;
	}
	
	public List<Country> getAllCountries() {
		return countryService.getAllCountries();
	}
	
	public Country getCountryByCountryCode(String countryCode) {
		return countryService.validateAndGetCountryByCountryCode(countryCode);
	}
}
