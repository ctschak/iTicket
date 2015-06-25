package com.csr.iticket.services;

import java.util.List;

import com.csr.iticket.dto.mongo.AgentDto;

public interface AgentService {
	
	AgentDto getAgent(int agentId);
	List<AgentDto> getAllAgents();
	AgentDto validateLogin(String username,String password);

}
