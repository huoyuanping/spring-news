package com.et.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 配置spring.xml类
 * @author Administrator
 *@Bean 调用方法产生bean ，bean的实例就是JdbcTemplate的实例
 */
@Configuration
public class MyConf {
	@Value("${url}")
	private String url;
	@Value("${username1}")
	private String username;
	@Value("${password2}")
	private String password;
	@Value("${driverClass}")
	private String driverClassName;
	/**
	 * 相当于配置文件中的"jdbcTemplate"
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		
		return new JdbcTemplate(dataSource);
	}
	/**
	 * 相当于配置文件中的"dataSource" 获取连接
	 * @return
	 */
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dmd=new DriverManagerDataSource();
		dmd.setUrl(url);
		dmd.setUsername(username);
		dmd.setPassword(password);
		dmd.setDriverClassName(driverClassName);
		return dmd;
	}
}
