package com.csr.iticket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.csr.iticket.services.CustomerService;

@Component
public class CustomerController extends Controller{

	@Autowired
	CustomerService customerService;
	
	//@Transactional
	public Result getAllTickets(){
		return ok(Json.toJson(customerService.getAllTickets()));
	}
	
}
