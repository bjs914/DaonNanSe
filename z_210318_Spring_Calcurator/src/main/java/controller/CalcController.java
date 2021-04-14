package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import calc.Calc;
import calc.CalcService;
	
@Controller	//서비스 연결을 위한 용도로 사용하는것이 좋음
public class CalcController {
	private CalcService calcService;
	
	public void setCalcService(CalcService calcService) {
		this.calcService = calcService;	//컨트롤러에서 이 서비스를 사용할 수 있도록 연동
	}
	
	@GetMapping("/calc")	//index.jsp에서 호출하면 여기로 옴
	public String handleCalc() {
		System.out.println("@@@@@@@@CalcController : handlerClac()");
		return "calc";//다시 jsp로 보내면
	}
	
	@PostMapping("/calc")	//여기로 다시왔다가, 메소드를 실행하고 다시 cal.jsp로 돌아감
	public String handleCalc(Model model,
			@RequestParam(value="calca", defaultValue = "0") int calca,
			@RequestParam(value="calcb", defaultValue = "0") int calcb) {
		
		System.out.println("$$$$$$$$$$$CalcController : handlerClac()");
		System.out.println("$$$$$$$$$$$ calc: "+ calca);
		System.out.println("$$$$$$$$$$$ calc: "+ calcb);
		
		model.addAttribute("calca",calca);
		model.addAttribute("calcb",calcb);
		model.addAttribute("calcsum",(calca+calcb));
		//model.addAttribute("calcsum",100);
		return "calc";	//결과를 다시 calc.jsp로 돌려줌
	}
	
}
