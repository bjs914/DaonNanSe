package com.webstore.shop.service;

import java.util.List;

import com.webstore.shop.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void updateAllStock();
	List<Product> getProductsByCategory(String category);//카테고리별 제품나열을 위한 메소드
}
