package com.webstore.shop.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
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
	
	@Bean	//스프링 빈 메시지 태그를 사용하기 위해 추가
	public MessageSource messageSource() {
		ResourceBundleMessageSource resource =
				new ResourceBundleMessageSource();
		resource.setBasename("messages");
		resource.setDefaultEncoding("utf-8");
		return resource;
	}
	
	@Bean //한글|영어를 지정하기 위한 빈(추후 인터셉트 할 때 진행 예정)
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("ko"));//기본으로 지정할 언어
		return resolver;
	}
	
	@Override	//사진 파일을 등록하기 위한 빈
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//이미지 불러오기와 관련
		registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
		//파일 불러오기와 관련됨(pdf형식)
		registry.addResourceHandler("/pdf/**").addResourceLocations("/resources/pdf/");	
	}
	
	@Bean	//파일찾기 및 images 디렉토리에 저장하기 위한 빈
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
}
