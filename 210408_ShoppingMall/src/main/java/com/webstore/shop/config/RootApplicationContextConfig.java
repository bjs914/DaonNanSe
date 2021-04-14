package com.webstore.shop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.webstore.shop")	//지정 패키지 전부를 검색(활용)할 수 있도록 지정합니다.
public class RootApplicationContextConfig {
	
	@Bean	//MariaDB와 연동하기 위한 Bean설정
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(org.mariadb.jdbc.Driver.class.getName());
		ds.setUrl("jdbc:mariadb://localhost:3306/webstore");
		ds.setUsername("test");	//MariaDB 접속 아이디
		ds.setPassword("1234");	//MariaDB 접속 비밀번호
		return ds;
	}
	
	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());	
		//NamedParameterJdbcTemplate을 사용하기 위한 빈
		//기존 jdbc는 변수 매핑을 ? 을 통해서 했지만 NamedParameterJdbcTemplate 객체에서는 변수 매핑을 이름을 
		//통해서 하는것이 가능하다. :variable 식으로 변수 앞에 : 를 두어 구분하기도 한다
	}
}
