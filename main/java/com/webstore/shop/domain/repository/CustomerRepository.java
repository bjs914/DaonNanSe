package com.webstore.shop.domain.repository;

import java.util.List;

import com.webstore.shop.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
