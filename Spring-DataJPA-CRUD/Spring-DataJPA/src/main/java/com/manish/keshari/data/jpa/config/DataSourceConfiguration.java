package com.manish.keshari.data.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/*
 *DataSourceConfiguration class is used to managed the DataSource.
 *  
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.manish.keshari.data.jpa.dao")
public class DataSourceConfiguration {

	/*
	 * this dataSource method is used to make a connection with DB
	 */
	@Bean
	DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/datajpa");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	/*
	 * entityManagerFactory method is used to create EntityManagerFactory and
	 * managed the connection with DB
	 */

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.manish.keshari.data.jpa.entity");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setPersistenceUnitName("manish");
		return entityManagerFactory;

	}

	/*
	 * transactionManager is used to managed transaction in JPA .
	 */
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	}

}
