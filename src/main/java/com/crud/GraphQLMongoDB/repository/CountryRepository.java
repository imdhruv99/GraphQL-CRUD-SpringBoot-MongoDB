package com.crud.GraphQLMongoDB.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.GraphQLMongoDB.model.Country;

public interface CountryRepository extends MongoRepository<Country, String>{
	
	Optional<Country> findByCountryCode(String countryCode);
}
