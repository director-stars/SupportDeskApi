package uk.ac.acm.config.db;


import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.AllArgsConstructor;
import uk.ac.acm.config.DatabaseConfig;

@Configuration(value = "acm_application_database")
@EnableJpaRepositories(
		basePackages = "uk.ac.acm.data.repo",
		entityManagerFactoryRef = "acm_application_database_entity_manager",
		transactionManagerRef = "acm_application_database_transaction_manager"
		)
@EnableConfigurationProperties({DatabaseConfig.class})
@AllArgsConstructor
public class PrimaryDatabaseConfiguration {
	
	private final DatabaseConfig configuration;
	@Bean(value = "acm_application_database_entity_manager")
	@Primary
	public LocalContainerEntityManagerFactoryBean userEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(userDataSource());
		em.setPackagesToScan(new String[] {"uk.ac.acm.data.model"});

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect",configuration.getDialect());
		properties.put("hibernate.hbm2ddl.auto",configuration.getAuto());
		properties.put("hibernate.format_sql", configuration.getFormat());
		properties.put("hibernate.show_sql", configuration.getAuto());
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Primary
	@Bean(value = "acm_application_database_data_store")
	public DataSource userDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(configuration.getDriverClassName());
		dataSource.setUrl(configuration.getJdbcurl());//+"?createDatabaseIfNotExist=true");
		dataSource.setUsername(configuration.getUsername());
		dataSource.setPassword(configuration.getPassword());

		return dataSource;
	}

	@Primary
	@Bean(value = "acm_application_database_transaction_manager")
	public PlatformTransactionManager userTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(userEntityManager().getObject());

		return transactionManager;
	}
}
