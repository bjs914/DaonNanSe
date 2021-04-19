package com.webstore.shop.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webstore.shop.domain.Customer;
import com.webstore.shop.domain.repository.CustomerRepository;

@Repository
public class MariaCustomerRepository implements CustomerRepository{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Customer> getAllCustomers() {
		Map<String,Object> params = new HashMap<String, Object>();

		List<Customer> result = jdbcTemplate.query(
				"SELECT * FROM customers", params,new CustomerMapper());
		return result;
	}
	
	private static final class CustomerMapper implements 
		RowMapper<Customer>{
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("ID"));
			customer.setName(rs.getString("NAME"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setnoOfOrdersMade(rs.getInt("noOfOrdersMade"));
			return customer;
		}
	}
	
}
