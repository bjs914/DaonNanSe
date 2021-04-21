package com.webstore.shop.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webstore.shop.domain.Product;
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
	
	@RequestMapping("/update/stock")//특정 제품의 재고량이 지정값 이하일때, 재고량을 1000증가
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
	
	@RequestMapping("/products/filter/{params}") 
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
			Model model) {//pathVar 속성은 URL의 행열 변수 구간을 식별, 
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")	//상품 상세정보 Controller
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	//제품 추가를 위한 컨트롤러(GET방식)
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	//제품 추가를 위한 컨트롤러(POST방식)
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductFrom(
			@ModelAttribute("newProduct") Product newProduct,
			BindingResult result, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			return "addProduct";
		}
		
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(
					"허용되지 않은 영역을 가져오려고 함 : "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		// 상품 이미지 메모리 내용을 정한 폴더에 파일로 보관		
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = 
				request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory 
						+ "resources\\images\\" + newProduct.getProductId() 
						+ ".png"));
			} catch (Exception e) {
				throw new RuntimeException("상품 이미지 저장에 실패했습니다", e);
			}
		}
		//상품 메뉴얼 pdf 파일 정한 폴더에 파일로 보관
		MultipartFile pdfManual = newProduct.getProductManual();
		if (pdfManual != null && !pdfManual.isEmpty()) {
			try {
				pdfManual.transferTo(new File(rootDirectory 
						+ "resources\\pdf\\" + newProduct.getProductId() 
						+ ".pdf"));
			} catch (Exception e) {
				throw new RuntimeException("상품 메뉴얼 저장에 실패했습니다.", e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}
	
	@InitBinder
	//setAllowedFields에 해당되는 데이터만 바인딩(=묶음)하는 것, 
	//즉 프로그래머가 지정하지 않는 필드의 데이터를 검증을 통해 입력되지 않도록 맞춤제작 하는 것과 의미가 유사함
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "unit*", "description", "manufacturer", "category", "condition",
				"productImage", "productManual", "unitsInOrder", "discontinued","productImage","productManual");				
	}
}
