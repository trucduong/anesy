package com.green.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * @ComponentScan("com.green")
 * -> @Controller
 * -> @Component
 * -> @Service
 * -> @Repository
 * ...
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.green")
public class MyServletConfig implements WebMvcConfigurer {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vResolver = new InternalResourceViewResolver();
		vResolver.setViewClass(JstlView.class);
		vResolver.setPrefix("/WEB-INF/view/");
		vResolver.setSuffix(".jsp");
		
		return vResolver;
	}
	
//	@Bean
//	@Qualifier("sessionFactory")
//	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		sessionFactory.setPackagesToScan("com.green.entity");
//		
//		Properties prop = new Properties();
//		prop.setProperty("hibernate.id.new_generator_mappings", "false");
//		prop.setProperty("hibernate.current_session_context_class", "thread");
//		prop.setProperty("hibernate.show_sql", "true");
//		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
//		prop.setProperty("hibernate.hbm2ddl.auto", "update");
//		sessionFactory.setHibernateProperties(prop);
//		
//		return sessionFactory;
//	}
//	
//	@Bean
//	@Qualifier("dataSource")
//	public DataSource dataSource() {
//		DriverManagerDataSource datasource = new DriverManagerDataSource();
//		datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		datasource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=anesy");
//		datasource.setUsername("root");
//		datasource.setPassword("root");
//		
//		return datasource;
//	}
	
	@Bean
	@Qualifier("sessionFactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.green.entity");
		
		Properties prop = new Properties();
		prop.setProperty("hibernate.id.new_generator_mappings", "false");
		prop.setProperty("hibernate.current_session_context_class", "thread");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		sessionFactory.setHibernateProperties(prop);
		
		return sessionFactory;
	}
	
	@Bean
	@Qualifier("dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/anesy");
		datasource.setUsername("root");
		datasource.setPassword("root");
		
		return datasource;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(-1);
	    return multipartResolver;
	}

}
