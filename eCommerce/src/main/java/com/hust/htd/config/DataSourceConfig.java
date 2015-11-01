package com.hust.htd.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@MapperScan("com.hust.htd.persistence.mapper")
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUsername("admin3TrXmKv");
		dataSource.setPassword("aFBzKNMFm3gF");
		dataSource.setUrl("jdbc:mysql://56303fcf2d52715f01000040-huytaduc.rhcloud.com:44906/ecommerce");
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		// sessionFactory.setTypeAliasesPackage("org.lanyonm.playground.domain");
		return sessionFactory;
	}
}
