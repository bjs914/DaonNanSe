package com.webstore.shop.domain.repository;

import java.util.List;

import com.webstore.shop.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();//고객리스트 확인을 위한 메소드
	void addCustomer(Customer customer);//고객리스트 추가를 위한 메소드
}
