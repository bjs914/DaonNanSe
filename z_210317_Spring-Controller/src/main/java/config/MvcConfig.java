package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc	//web.xml에서 여기를 연결, 어노테이션 기반의 SpringMvc를 구성할때 필요한 Bean설정을 자동으로 해주는 기능을 가지고있음.
public class MvcConfig implements WebMvcConfigurer{	
	//WebMvcConfigurer를 상속받게 되면 @EnableWebMvc가 자동으로 세팅해주는 설정에 개발자가 원하는 설정을 추가로 Override가 가능하다.
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/",".jsp");	//view폴더 및 하위 클래스 연결
	}
}
