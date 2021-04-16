package com.webstore.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webstore.shop.service.CustomerService;

@Controller
@RequestMapping("market")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")	//고객관련 데이터를 보기위한 url주소
	public String list(Model model) {
		model.addAttribute("customers",customerService.getAllCustomers());	
							//customers라는 이름으로 모든 고객리스트를 model에 저장
		return "customers";	//반환값을 지정, 고객리스트를 보여주기 위한 view페이지(jsp)
	}
}
