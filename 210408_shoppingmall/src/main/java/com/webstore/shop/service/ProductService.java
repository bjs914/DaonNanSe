package com.webstore.shop.service;

import java.util.List;
import java.util.Map;

import com.webstore.shop.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void updateAllStock();
	List<Product> getProductsByCategory(String category);//카테고리별 제품나열을 위한 메소드
	//카테고리별 제품나열, Matrix 활용
	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	Product getProductById(String productID);//상품 상세정보 메소드
	void addProduct(Product product);//제품 추가 메소드
}
