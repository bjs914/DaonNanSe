package com.test.js;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	//서버 도메인을 /hello로 지정
	@GetMapping("/hello")	
	
	public String hello(Model model, @RequestParam(value="name", required=false) String name) {
						//model인터페이스에 저장, 입력값은 사용자가 입력하게 되며, 항상 필요로 되어지는 것이 아니기 때문에 required는 false로 지정
	model.addAttribute("hi","반가워요 ->"+name);
	//@RequestPara에서 지정한 value명을 "hi"로 지정했으며 내용은 name이라는 변수명에 저장/호출 가능하도록 지정
	
	return "hello";
	//반환값은 hello.jsp를 의미함
	}
}
