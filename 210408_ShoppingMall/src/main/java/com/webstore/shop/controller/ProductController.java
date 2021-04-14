package com.webstore.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.webstore.shop.service.ProductService;

@Controller
@RequestMapping("market")	//클래스에서 선언된 도메인주소 앞에 오도록 지정
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")	//제품 정보를 보기위한 RequestMapping
	public String list(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		return "products"; // 뷰 이름 반환
	}
	
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products";
	}
	
	@RequestMapping("/products/{category}")	
					//url경로에 {템플릿 변수}를 넣어주는 것을 의미, 즉 view 페이지에서 입력한 category 값을
					//DB의 cateogory탭에서 확인하여 url경로에 넣어주게 된다.
					//ReqeustMapping("/{변수명}")과 @PathValrable("변수명")이 꼭 같아야만 함
	public String getProductsByCategory(Model model,
			@PathVariable("category") String productCategory) {
	//@PathVariable : URL 경로에 변수를 넣어주는 것
		model.addAttribute("products",
				productService.getProductsByCategory(productCategory));
		return "products";
	}
}
