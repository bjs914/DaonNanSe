package com.webstore.shop.service;

import java.util.List;

import com.webstore.shop.domain.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void addCustomer(Customer customer);//고객 추가를 위한 메소드
}
