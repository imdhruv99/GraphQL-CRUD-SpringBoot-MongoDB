package com.crud.GraphQLMongoDB.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.crud.GraphQLMongoDB.model.Country;




@EnableMongoAuditing
@Configuration
public class MongoConfig {

	private MongoTemplate mongoTemplate;
	private MongoMappingContext mongoMappingContext;

	public MongoConfig(MongoTemplate mongoTemplate, MongoMappingContext mongoMappingContext) {
		this.mongoTemplate = mongoTemplate;
		this.mongoMappingContext = mongoMappingContext;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initIndicesAfterStartup() {
		IndexOperations indexOps = mongoTemplate.indexOps(Country.class);
		IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
		resolver.resolveIndexFor(Country.class).forEach(indexOps::ensureIndex);
	}

}
