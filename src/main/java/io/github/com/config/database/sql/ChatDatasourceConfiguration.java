package io.github.com.config.database.sql;

import jakarta.persistence.EntityManagerFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "chatEntityManagerFactory",
	transactionManagerRef = "chatTransactionManager",
	basePackages = { "io.github.com.repositories.chat" })
public class ChatDatasourceConfiguration {
	@Bean(name="chatProperties")
	@ConfigurationProperties("spring.datasource.chat")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name="chatDatasource")
	@ConfigurationProperties(prefix = "spring.datasource.chat")
	public DataSource datasource(@Qualifier("chatProperties") @NotNull DataSourceProperties properties){
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean(name="chatEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
		@NotNull EntityManagerFactoryBuilder builder,
		@Qualifier("chatDatasource") DataSource dataSource
		){
		return builder.dataSource(dataSource)
			.packages("io.github.com.entities.chat")
			.persistenceUnit("chat").build();
	}

	@Bean(name = "chatTransactionManager")
	@ConfigurationProperties("spring.jpa")
	public PlatformTransactionManager transactionManager(
		@Qualifier("chatEntityManagerFactory") EntityManagerFactory entityManagerFactory
	) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
