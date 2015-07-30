package com.csr.iticket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dto.mongo.CustomerDto;
import com.csr.iticket.dto.mongo.UserDto;
import com.csr.iticket.services.UserService;

import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

@Component
public class UserController extends Controller {
	
	@Autowired
	UserService userService;
	
	@BodyParser.Of(BodyParser.Json.class)
	public Result saveorupdate(){
		//Parse POST data
		System.out.println(" welcome to java save or update jspn data:::::"+request().body().asJson());
	     UserDto userDto = Json.fromJson(request().body().asJson(), UserDto.class);
	     System.out.println("welcome to next level");
	    // UserDto customerDto = Json.fromJson(request().body().asJson(), UserDto.class);
		 Logger.debug("Parsing Success ########"+userDto.user_id);
		 userService.saveOrUpdateCustomer(userDto);
		return ok();
	}
	

}
