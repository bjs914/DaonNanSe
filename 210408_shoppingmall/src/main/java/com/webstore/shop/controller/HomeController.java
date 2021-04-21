package com.webstore.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")	//입력받을 주소값을 지정
	public String welcome(Model model) {	
						//Model은 Map구조이기에 key, value값으로 지정가능
		//Model 인터페이스에 "greeting"이라는 변수지정, "환영합니다"라는 value입력		
		model.addAttribute("greeting","환영합니다.");	
		//Model 인터페이스에 "tagline"이라는 변수지정, "웹 스토어입니다."라는 value입력
		model.addAttribute("tagline","웹 스토어입니다.");	
		return "welcome";	//welcome.jsp 반환
	}
}
