package io.github.com.config.database.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoRepositories(
	basePackages = { "io.github.com.repositories.skills" },
	mongoTemplateRef = "skillMongoTemplate"
)
@EnableConfigurationProperties
public class SkillDataSourceConfiguration {
	@Primary
	@Bean(name = "skillProperties")
	@ConfigurationProperties(prefix = "spring.datasource.skills")
	public MongoProperties primaryProperties() {
		return new MongoProperties();
	}

	@Bean(name = "skillMongoClient")
	public MongoClient mongoClient(@Qualifier("skillProperties") @NotNull MongoProperties mongoProperties) {
		MongoCredential credential = MongoCredential
			.createCredential(
				mongoProperties.getUsername(),
				mongoProperties.getAuthenticationDatabase(),
				mongoProperties.getPassword())
			;
		return MongoClients.create(
			MongoClientSettings
				.builder()
				.applyToClusterSettings(builder -> builder
				.hosts(singletonList(
					new ServerAddress(
						mongoProperties.getHost(),
						mongoProperties.getPort()
					))))
			.credential(credential)
			.build());
	}

	@Primary
	@Bean(name = "skillMongoDBFactory")
	public MongoDatabaseFactory mongoDatabaseFactory(
		@Qualifier("skillMongoClient") MongoClient mongoClient,
		@Qualifier("skillProperties") @NotNull MongoProperties mongoProperties) {
		return new SimpleMongoClientDatabaseFactory(mongoClient, mongoProperties.getDatabase());
	}

	@Primary
	@Bean(name = "skillMongoTemplate")
	public MongoTemplate skillMongoTemplate(@Qualifier("skillMongoDBFactory") MongoDatabaseFactory mongoDatabaseFactory) {
		return new MongoTemplate(mongoDatabaseFactory);
	}
}
