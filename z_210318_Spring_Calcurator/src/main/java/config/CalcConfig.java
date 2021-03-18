package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import calc.CalcService;

@Configuration	//프로그램에 빈으로 등록한 것들을 사용하겠다는 의미,Configuration 끼리 Autowired를 하기 위해 컨피규레이션 만듦
public class CalcConfig {

	@Bean
	public CalcService calcService() {
		//ControllerConfig에서 공유해서 사용하기 위해 선언 
		return new CalcService();
	}
}
