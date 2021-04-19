package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import calc.CalcService;
import controller.CalcController;
import controller.CalcController2;
import controller.CalcController3;
import controller.CalcController4;

//Controller들을 모아놓고, Service와 연결하기 위한 클래스
@Configuration
public class ControllerConfig {
	
	@Autowired
	public CalcService calcService;
	
	@Bean
	public CalcController calcController() {
		CalcController controller = new CalcController();
		controller.setCalcService(calcService);
		return controller;
	}

	@Bean
	public CalcController2 calcController2() {
		CalcController2 controller = new CalcController2();
		controller.setCalcService(calcService);
		return controller;
	}
	
	@Bean
	public CalcController3 calcController3() {
		CalcController3 controller = new CalcController3();
		controller.setCalcService(calcService);
		return controller;
	}
	
	@Bean
	public CalcController4 calcController4() {
		CalcController4 controller = new CalcController4();
		controller.setCalcService(calcService);
		return controller;
	}
}
