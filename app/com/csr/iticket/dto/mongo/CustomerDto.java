package com.csr.iticket.dto.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dao.CustomerDao;
import com.csr.iticket.dto.DtoMapper;
import com.csr.iticket.entities.mongo.Customer;


public class CustomerDto {

	public String id;
	public Integer customer_id;
	public String first_name;
	public String last_name;
	public String email;
	public Integer active;
	public String inserted_date;
	public String phone;
	public Integer ticket_id;
	public String issue_description;
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
			Customer customer = customerDao.findById(customerDto.customer_id);
    		mapDtoToEntity(customerDto,customer);
    		return customer;
    	}
    	
    	public Customer newEntity(CustomerDto customerDto){
    		Customer customer = new Customer();
    		mapDtoToEntity(customerDto,customer);
    		return customer;
    	}
    	
    	public void mapDtoToEntity(CustomerDto customerDto, Customer customer){
    		customer.setCustomer_id(customerDto.customer_id);
    		customer.setFirst_name(customerDto.first_name);
    		customer.setLast_name(customerDto.last_name);
    		customer.setEmail(customerDto.email);
    		customer.setActive(customerDto.active);
    		customer.setInserted_date(customerDto.inserted_date);
    		customer.setPhone(customerDto.phone);
    		customer.setTicket_id(customerDto.ticket_id);
    		customer.setIssue_description(customerDto.issue_description);
    		customer.setTicket_comments(customerDto.ticket_comments);
    		customer.setAgent_id(customerDto.agent_id);
    		customer.setAssigned_to(customerDto.assigned_to);
    		customer.setStatus(customerDto.status);
    	}
    	
    	@Override
    	public void mapEntityToDto(Customer customer,CustomerDto dto){
    		dto.customer_id = customer.getCustomer_id();
    		dto.first_name = customer.getFirst_name();
    		dto.last_name = customer.getLast_name();
    		dto.email = customer.getEmail();
    		dto.active = customer.getActive();
    		dto.inserted_date = customer.getInserted_date();
    		dto.phone = customer.getPhone();
    		dto.id = customer.getId().toString();
    		dto.ticket_id = customer.getTicket_id();
    		dto.issue_description = customer.getIssue_description();
    		dto.ticket_comments = customer.getTicket_comments();
    		dto.agent_id = customer.getAgent_id();
    		dto.assigned_to = customer.getAssigned_to();
    		dto.status = customer.getStatus();
    	}
		
	}
	
}
