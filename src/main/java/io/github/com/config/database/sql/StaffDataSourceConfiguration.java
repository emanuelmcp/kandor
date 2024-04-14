package io.github.com.config.database.sql;

import jakarta.persistence.EntityManagerFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "staffEntityManagerFactory",
	transactionManagerRef = "staffTransactionManager",
	basePackages = { "io.github.com.repositories.staff" })
public class StaffDataSourceConfiguration {
	@Primary
	@Bean(name="staffProperties")
	@ConfigurationProperties("spring.datasource.staff")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name="staffDatasource")
	@ConfigurationProperties(prefix = "spring.datasource.staff")
	public DataSource datasource(@Qualifier("staffProperties") @NotNull DataSourceProperties properties){
		return properties.initializeDataSourceBuilder().build();
	}

	@Primary
	@Bean(name="staffEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
		@NotNull EntityManagerFactoryBuilder builder,
		@Qualifier("staffDatasource") DataSource dataSource
	){

		return builder.dataSource(dataSource)
			.packages("io.github.com.entities.staff")
			.persistenceUnit("staff").build();
	}

	@Primary
	@Bean(name = "staffTransactionManager")
	@ConfigurationProperties("spring.jpa")
	public PlatformTransactionManager transactionManager(
		@Qualifier("staffEntityManagerFactory") EntityManagerFactory entityManagerFactory
	) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
