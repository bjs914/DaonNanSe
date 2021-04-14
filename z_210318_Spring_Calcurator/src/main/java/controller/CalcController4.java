package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import calc.Calc;
import calc.Calc2;
import calc.Calc4;
import calc.CalcService;
	
@Controller	//서비스 연결을 위한 용도로 사용하는것이 좋음
public class CalcController4 {
	private CalcService calcService;
	
	public void setCalcService(CalcService calcService) {
		this.calcService = calcService;	//컨트롤러에서 이 서비스를 사용할 수 있도록 연동
	}
	
	@GetMapping("/calc4")
	public String handelCalc2(Calc4 calc) {
		return "calc4";	//calc2.jsp로 반환
	}
	
	@PostMapping("/calc4")
	public String handleCal3(Calc4 calc) {
		calcService.calc4(calc);
		return "calc4";	//calc2.jsp로 반환
	}
	
}
