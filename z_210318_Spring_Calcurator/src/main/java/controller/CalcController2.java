package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import calc.Calc;
import calc.Calc2;
import calc.CalcService;
	
@Controller	//서비스 연결을 위한 용도로 사용
public class CalcController2 {
	private CalcService calcService;
	
	public void setCalcService(CalcService calcService) {
		this.calcService = calcService;	//컨트롤러에서 이 서비스를 사용할 수 있도록 연동
	}
	
	@GetMapping("/calc2")
	public String handelCalc2(Calc2 calc) {
		return "calc2";	//calc2.jsp로 반환
	}
	
	@PostMapping("/calc2")
	public String handleCal3(Calc2 calc) {
		calcService.calc2(calc);
		return "calc2";	//calc2.jsp로 반환
	}
	
}
