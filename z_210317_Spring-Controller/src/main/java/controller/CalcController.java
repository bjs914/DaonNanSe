package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	@GetMapping("/calc")	//도메인에서 /calc를 호출하면 받음
	public String handleCalc() {

		//index에서 입력한 도메인주소가 오는지 확인하기 위해 아래 코드 입력
		System.out.println("@@@@@CalcController : handlerCalc()");
		
		return "calc";	
	//도메인주소 입력이 get방식으로 정상작동되면 다시 calc.jsp로 반환 → calc.jsp에서 method방식을 post로 했기 때문에 아래 PostMaping으로 돌려주기 위함
	}
	
	@PostMapping("/calc")	//calc.jsp에서 두 값을 입력하면 실질적으로 계산을 구현함. post방식이기에 PostMapping사용
	public String handleCalc(Model model,
			@RequestParam(value="calca", defaultValue = "0") int calca,
			//calc.jsp에서 입력한 첫번째 값의 이름을 calca로 지정했기에 value값을 동일하게 지정, 이 value값을 int calca에 저장
			
			@RequestParam(value="calcb", defaultValue = "0") int calcb) {
			//calc.jsp에서 입력한 첫번째 값의 이름을 calca로 지정했기에 value값을 동일하게 지정, 이 value값을 int calca에 저장
		
		//마찬가지로 calc.jsp에서 입력한 값이 제대로 넘어오는지 확인하기 위한 코드
		System.out.println("$$$$$$$$CalController : handlerCalc()");
		
		model.addAttribute("calca",calca);	//calc.jsp에서 넘어온 파라미터를 @RequestParam에서 선언한 int cala에 넣는과정
		model.addAttribute("calcb",calcb);	//calc.jsp에서 넘어온 파라미터를 @RequestParam에서 선언한 int calb에 넣는과정
		model.addAttribute("calcsum",(calca+calcb));	//위 두 값을 이용한 실질적으로 내가 원하는 연산을 지정
		
		return "calc";	//결과를 다시 calc.jsp로 돌려줌
	}
}
