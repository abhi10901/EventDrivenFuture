package com.ajb.event.driven.future.config;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@Configuration
@PropertySource("classpath:mongodb.properties")
public class MongoDBConnectionConfig extends AbstractMongoConfiguration {

	@Value("${mongodb.url}")
	private static String mongodbUrl;

	@Value("${mongodb.database}")
	private String mongodbDatabase;

	@Value("${mongodb.port}")
	private int mongodbPort;

	@Override
	public Mongo mongo() throws Exception {
		MongoClientOptions mongoOptions =
				new MongoClientOptions
					.Builder()
					.maxWaitTime(1000 * 60 * 5)
					//.minConnectionsPerHost(10)
					//.maxConnectionIdleTime(1000 * 10)
					.build();
		
		MongoClient client = new MongoClient(mongodbUrl, mongoOptions);
		return client;
	}
	
	@Override
	protected String getDatabaseName() {
		return mongodbDatabase;
	}

	// To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
