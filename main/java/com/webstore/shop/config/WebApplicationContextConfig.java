package com.webstore.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//web.xml의 역할을 하는 클래스
//Spring MVC를 자동으로 구성하여 사용하기 위한 어노테이션
@Configuration	//클래스가 빈 메소드를 포함
@EnableWebMvc	//Spring MVC가 3가지 빈을 구성하게함, @Controller, @RequestMapping 등을 사용하려면 필요함
@ComponentScan("com.webstore.shop")	//스캔하려는 패키지명을 지정
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter{
//WebMvcConfigurerAdapter : 추상메소드, 스프링MVC 설정의 추가적인 커스텀을 위해서 사용됨, Spring5이상에서는 사용하지 않음
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		//ViewResolver를 구현하는 빈
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/view/");	//도메인에서 앞쪽의 경로에 해당하는 것을 미리 지정
		resolver.setSuffix(".jsp");	//도메인에서 뒤쪽의 경로(페이지 종류 등)를 미리 지정
									//Prefix, Suffix 지정결과 : (/WEB-INF/view/)welcome(.jsp)
		return resolver;
	}
}
