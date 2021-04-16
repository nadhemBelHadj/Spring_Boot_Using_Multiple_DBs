package com.nadhem.multiDB.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "produitEntityManagerFactory", 
transactionManagerRef = "produitTransactionManager", basePackages = {
		"com.nadhem.multiDB.produit.repos" })
public class ProduitDBConfig {
	@Primary
	@Bean(name = "produitDataSource")
	@ConfigurationProperties(prefix = "spring.produit.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "produitEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean produitEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("produitDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages("com.nadhem.multiDB.entities.produit").persistenceUnit("Produit").build();
	}

	@Primary
	@Bean(name = "produitTransactionManager")
	public PlatformTransactionManager produitTransactionManager(
			@Qualifier("produitEntityManagerFactory") EntityManagerFactory produitEntityManagerFactory) {
		return new JpaTransactionManager(produitEntityManagerFactory);
	}
}
