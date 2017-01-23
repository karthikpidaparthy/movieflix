package io.movieflix.api;



import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean createEmf()
	{
		LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		emf.setPackagesToScan("io.movieflix.api.entity");
		
		emf.setDataSource(dataSource());
		emf.setJpaProperties(jpaProperties());
		return emf;
		
	}
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/moviefilx?useSSL=false");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("simplerobot90");
		return driverManagerDataSource;
	}
	
	@Bean
	public PlatformTransactionManager txrMgr(EntityManagerFactory emf)
	{
		JpaTransactionManager txrMgr=new JpaTransactionManager(emf);
		return txrMgr;
	}
	
	private Properties jpaProperties()
	{
		Properties properties=new Properties();
		properties.setProperty(PersistenceUnitProperties.WEAVING, "false");
		properties.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
		properties.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		return properties;
	}
	
}
