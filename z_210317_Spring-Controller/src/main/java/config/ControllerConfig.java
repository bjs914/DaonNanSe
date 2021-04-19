package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.CalcController;

//mvc 연결
@Configuration
public class ControllerConfig {

	@Bean
	public CalcController calcController() {	//실제 연산을 구현하는 클래스 빈으로 등록
		return new CalcController();
	}
}
