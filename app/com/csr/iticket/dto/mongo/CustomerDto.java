package com.csr.iticket.dto.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dao.CustomerDao;
import com.csr.iticket.dto.DtoMapper;
import com.csr.iticket.entities.mongo.Customer;


public class CustomerDto {

	public String id;
	public Integer customerId;
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	public String email;
	public Integer active;
	public String insertedDate;
	public String phone;
	public Integer ticket_id;
	public String ticket_comments;
	public Integer agent_id;
	public Integer assigned_to;
	public String status;
	
	@Component
    public static class Mapper extends DtoMapper<Customer, CustomerDto>{
		
		@Autowired
		CustomerDao customerDao;
		
		@Override
		public CustomerDto newDto(){
			return new CustomerDto();
		}
		
		public Customer fromDto(CustomerDto customerDto){
			Customer customer = customerDao.findById(customerDto.customerId);
    		mapDtoToEntity(customerDto,customer);
    		return customer;
    	}
    	
    	public Customer newEntity(CustomerDto customerDto){
    		Customer customer = new Customer();
    		mapDtoToEntity(customerDto,customer);
    		return customer;
    	}
    	
    	public void mapDtoToEntity(CustomerDto customerDto, Customer customer){
    		customer.setCustomer_id(customerDto.customerId);
    		customer.setFirst_name(customerDto.firstName);
    		customer.setLast_name(customerDto.lastName);
    		customer.setUser_name(customerDto.userName);
    		customer.setPassword(customerDto.password);
    		customer.setEmail(customerDto.email);
    		customer.setActive(customerDto.active);
    		customer.setInserted_date(customerDto.insertedDate);
    		customer.setPhone(customerDto.phone);
    		customer.setTicket_id(customerDto.ticket_id);
    		customer.setTicket_comments(customerDto.ticket_comments);
    		customer.setAgent_id(customerDto.agent_id);
    		customer.setAssigned_to(customerDto.assigned_to);
    		customer.setStatus(customerDto.status);
    	}
    	
    	@Override
    	public void mapEntityToDto(Customer customer,CustomerDto dto){
    		dto.customerId = customer.getCustomer_id();
    		dto.firstName = customer.getFirst_name();
    		dto.lastName = customer.getLast_name();
    		dto.userName = customer.getUser_name();
    		dto.password = customer.getPassword();
    		dto.email = customer.getEmail();
    		dto.active = customer.getActive();
    		dto.insertedDate = customer.getInserted_date();
    		dto.phone = customer.getPhone();
    		dto.id = customer.getId().toString();
    		dto.ticket_id = customer.getTicket_id();
    		dto.ticket_comments = customer.getTicket_comments();
    		dto.agent_id = customer.getAgent_id();
    		dto.assigned_to = customer.getAssigned_to();
    		dto.status = customer.getStatus();
    	}
		
	}
	
}
