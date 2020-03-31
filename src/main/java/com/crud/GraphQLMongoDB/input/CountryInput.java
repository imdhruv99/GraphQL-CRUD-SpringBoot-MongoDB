package com.crud.GraphQLMongoDB.input;

import lombok.Data;

@Data
public class CountryInput {
	
	private String countryCode;
	private String countryName;
	private String region;
}
