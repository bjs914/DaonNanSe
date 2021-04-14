package com.webstore.shop.domain.repository;

import java.util.List;

import com.webstore.shop.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();	//제품 전체리스트를 보기위한 메소드
	void updateStock(String productId, long noOfUnits);	//제품 수정을 위한 메소드
	List<Product> getProductByCategory(String category);//카테고리별 제품을 확인하기 위한 메소드
}
