package com.webstore.shop.exception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3841910634035684072L;
	private String productId;
	public ProductNotFoundException(String productId) {
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
}
