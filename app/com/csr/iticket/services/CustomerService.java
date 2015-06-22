package com.csr.iticket.services;

import java.util.List;

import com.csr.iticket.dto.mongo.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomer(int customerId);
	List<CustomerDto> getAllCustomers();
	void deleteCustomer(String customerId);
	void saveCustomer(CustomerDto customerDto);
	
}
