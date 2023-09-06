package com.personal.security.context.database.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.personal.security.context.repository")
@EnableTransactionManagement
public class DatabaseJpaConfigController 
{
	@Bean
	public DataSource dataSource()
	{
		DataSourceBuilder dataSource = DataSourceBuilder.create();
		dataSource.driverClassName("org.postgresql.Driver");
		dataSource.url("jdbc:postgresql://localhost:5432/spring_security");
		dataSource.username("postgres");
		dataSource.password("renan1994");
		return dataSource.build();
	}// dataSource
	
	/**
	 * Utilizado para criar o adapter que neste caso será o hibernate 
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		managerFactoryBean.setPackagesToScan("com.personal.security.entity");
		managerFactoryBean.setDataSource(dataSource());
		
		AbstractJpaVendorAdapter abstractJpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		managerFactoryBean.setJpaVendorAdapter(abstractJpaVendorAdapter);
		managerFactoryBean.setJpaProperties(jpaProperties());
		managerFactoryBean.afterPropertiesSet();
		
		return managerFactoryBean.getObject();
		
	}// entityManagerFactory
	
	
	private Properties jpaProperties()
	{
		// setar as propriedades do hibernate
		Properties properties = new Properties();
		return properties;
	}// jpaProperties
	
	
	@Bean
	public PlatformTransactionManager transactionManager()
	{
		JpaTransactionManager jpaTransactionManager =  new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		jpaTransactionManager.setGlobalRollbackOnParticipationFailure(false);
		
		return jpaTransactionManager;
	}// transactionManager
	
}// class
