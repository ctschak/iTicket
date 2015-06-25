package com.csr.iticket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;

import com.csr.iticket.dto.mongo.CustomerDto;
import com.csr.iticket.services.CustomerService;

@Component
public class CustomerController extends Controller{

	@Autowired
	CustomerService customerService;
	
	//@Transactional
	public Result getAllTickets(){
		return ok(Json.toJson(customerService.getAllTickets()));
	}
	@BodyParser.Of(BodyParser.Json.class)
	public Result saveorupdate(){
		//Parse POST data
		CustomerDto customerDto = Json.fromJson(request().body().asJson(), CustomerDto.class);
		Logger.debug("Parsing Success ########"+customerDto.ticket_id);
		customerService.saveOrUpdateCustomer(customerDto);
		return ok();
	}
}
