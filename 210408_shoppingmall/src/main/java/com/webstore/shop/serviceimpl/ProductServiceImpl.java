package com.webstore.shop.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.shop.domain.Product;
import com.webstore.shop.domain.repository.ProductRepository;
import com.webstore.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public void updateAllStock() {
		List<Product> allProducts = productRepository.getAllProducts();
		
		for(Product product : allProducts) {
			if(product.getUnitsInStock()<500) {
				productRepository.updateStock(product.getProductId(),
						product.getUnitsInStock()+1000);
			}
		}
	}

	public List<Product> getProductsByCategory(String category) {	
		return productRepository.getProductByCategory(category);
	}

	//Matrix 활용 구현체
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	//상품 상세페이지 구현체
	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}

	//제품 추가페이지 구현체
	public void addProduct(Product product) {
		productRepository.addProduct(product);		
	}

}
