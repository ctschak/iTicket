package com.csr.iticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dao.CustomerDao;
import com.csr.iticket.dto.mongo.CustomerDto;
import com.csr.iticket.entities.mongo.Customer;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerDto.Mapper dtoMapper;

	@Override
	public CustomerDto getCustomer(int customerId) {
		Customer customer = customerDao.findById(customerId);
		return dtoMapper.fromEntity(customer);
	}

	@Override
	public List<CustomerDto> getAllTickets() {
		List<Customer> customers= customerDao.findAll();
		return dtoMapper.fromEntities(customers);
	}

	@Override
	public void deleteCustomer(String customerId) {
		customerDao.deleteCustomer(customerId);
		
	}

	@Override
	public void saveOrUpdateCustomer(CustomerDto customerDto) {
		customerDao.saveOrUpdateCustomer(dtoMapper.newEntity(customerDto));
		
	}
	
	
	
	
	
}
