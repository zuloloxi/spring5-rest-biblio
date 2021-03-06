package net.javaguides.springmvc.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppContext {

	@Autowired
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "net.javaguides.springmvc.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

//	@Autowired
//	DataSource dataSource;

//	@Bean
//	public JdbcTemplate getJdbcTemplate(){
//	  return new JdbcTemplate(dataSource);
//	}
	
	//default username : sa, password : ''
//	@Bean(initMethod = "start", destroyMethod = "stop")
//	public Server startDBManager() throws SQLException {
//	    Server.createWebServer();
//	}
	
//	@Bean
/*	public DataSource dataSource() {
		
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
			.addScript("db/sql/create-db.sql")
			.addScript("db/sql/insert-data.sql")
			.build();
		return db;
	}
*/	
	@Bean 
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	/*@PostConstruct
	public void getDbManager(){
	   DatabaseManagerSwing.main(
		//new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});  //in memory database
	    new String[] {"--driver","org.hsqldb.jdbcDriver", "--url", "//jdbc:hsqldb:hsql://localhost/testdb", "--user", "sa", "--password", ""}); //localhost testdb
	}*/
}
