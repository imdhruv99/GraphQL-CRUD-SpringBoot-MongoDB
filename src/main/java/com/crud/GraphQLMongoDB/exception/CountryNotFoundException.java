package com.crud.GraphQLMongoDB.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class CountryNotFoundException extends RuntimeException implements GraphQLError {
	

	private static final long serialVersionUID = 1L;
	private final Map<String, Object> extensions = new HashMap<>();
	
	public CountryNotFoundException(String message, String field, String value) {
		super(message);
		extensions.put(field, value);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}
	
	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

}
