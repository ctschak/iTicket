package com.csr.iticket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.csr.iticket.services.AgentService;

@Component
public class AgentController  extends Controller{
	
	@Autowired
	AgentService agentService;
	
	public Result getAllAgents(){
		return ok(Json.toJson(agentService.getAllAgents()));
	}
	
	public Result validateLogin(String username, String password){
		Logger.debug("validateLogin ########"+username+"    "+password);
		return ok(Json.toJson(agentService.validateLogin(username,password)));
	}
}
