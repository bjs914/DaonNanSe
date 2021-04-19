package com.webstore.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webstore.shop.domain.Customer;
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
	
	@RequestMapping(value="/customers/add", method = RequestMethod.GET)
	//고객 추가를 위한 컨트롤러
	public String getAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {		
		return "addCustomer";//고객추가를 위한 뷰페이지 반환
	}
	
	@RequestMapping(value="/customers/add", method=RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
		customerService.addCustomer(newCustomer);
		return "redirect:/market/customers";//고객 추가 완료 후, 고객목록 페이지로 보냄
	}
}
