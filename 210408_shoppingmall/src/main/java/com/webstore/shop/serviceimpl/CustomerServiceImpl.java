package com.webstore.shop.serviceimpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.shop.domain.Customer;
import com.webstore.shop.domain.repository.CustomerRepository;
import com.webstore.shop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}
	
	@Override
	public void addCustomer(Customer customer) {
		customerRepository.addCustomer(customer);		
	}


	
	
}
