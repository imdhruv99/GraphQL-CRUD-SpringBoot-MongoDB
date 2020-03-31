package com.crud.GraphQLMongoDB.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.crud.GraphQLMongoDB.input.CountryInput;
import com.crud.GraphQLMongoDB.model.Country;
import com.crud.GraphQLMongoDB.service.CountryService;

import ma.glasnost.orika.MapperFacade;

@Component
public class Mutation implements GraphQLMutationResolver{
	
	private final CountryService countryService;
	private final MapperFacade mapperFacade;
	
	public Mutation(CountryService countryService, MapperFacade mapperFacade) {
		this.countryService = countryService;
		this.mapperFacade = mapperFacade;
	}
	
	public Country createCountry(CountryInput countryInput) {
		Country country = mapperFacade.map(countryInput, Country.class);
		return countryService.saveCountry(country);
	}
	
	public Country updateCountry(String id, CountryInput countryInput) {
		Country country = countryService.validateAndGetCountryById(id);
		mapperFacade.map(countryInput, country);
		return countryService.saveCountry(country);
	}
	
	public Country deleteCountry(String id) {
		Country country = countryService.validateAndGetCountryById(id);
		countryService.deleteCountry(country);
		return country;
	}
}
