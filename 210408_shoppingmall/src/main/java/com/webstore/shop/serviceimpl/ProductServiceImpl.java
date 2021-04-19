package com.webstore.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.shop.domain.Product;
import com.webstore.shop.domain.repository.ProductRepository;
import com.webstore.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public void updateAllStock() {
		List<Product> allProducts = productRepository.getAllProducts();
		
		for(Product product : allProducts) {
			if(product.getUnitsInStock()<500) {
				productRepository.updateStock(product.getProductId(),
						product.getUnitsInStock()+1000);
			}
		}
	}

	@Override
	public List<Product> getProductsByCategory(String category) {	
		return productRepository.getProductByCategory(category);
	}

}
