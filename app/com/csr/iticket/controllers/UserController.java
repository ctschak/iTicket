package com.csr.iticket.controllers;

import org.springframework.stereotype.Component;

import com.csr.iticket.dto.mongo.CustomerDto;
import com.csr.iticket.dto.mongo.UserDto;

import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

@Component
public class UserController extends Controller {
	
	@BodyParser.Of(BodyParser.Json.class)
	public Result saveorupdate(){
		//Parse POST data
		System.out.println(" hemakanth  welcome to java save or update jspn data:::::"+request().body().asJson());
	     UserDto userDto = Json.fromJson(request().body().asJson(), UserDto.class);
		//CustomerDto customerDto = Json.fromJson(request().body().asJson(), CustomerDto.class);
		//Logger.debug("Parsing Success ########"+customerDto.ticket_id);
		//customerService.saveOrUpdateCustomer(customerDto);
		return ok();
	}
	

}
