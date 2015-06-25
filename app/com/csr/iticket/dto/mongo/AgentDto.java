package com.csr.iticket.dto.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dao.AgentDao;
import com.csr.iticket.dto.DtoMapper;
import com.csr.iticket.entities.mongo.Agent;

public class AgentDto {
	
	public String id;
	public Integer agentId;
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	public String email;
	public Integer active;
	public String insertedDate;
	public String phone;
	
	@Component
    public static class Mapper extends DtoMapper<Agent, AgentDto>{
		
		@Autowired
		AgentDao agentDao;
		
		@Override
		public AgentDto newDto(){
			return new AgentDto();
		}
		
		public Agent fromDto(AgentDto dto){
			Agent agent = agentDao.findById(dto.agentId);
    		mapDtoToEntity(dto,agent);
    		return agent;
    	}
    	
    	public Agent newEntity(AgentDto dto){
    		Agent agent = new Agent();
    		mapDtoToEntity(dto,agent);
    		return agent;
    	}
    	
    	public void mapDtoToEntity(AgentDto dto, Agent agent){
    		agent.setAgent_id(dto.agentId);
    		agent.setFirst_name(dto.firstName);
    		agent.setLast_name(dto.lastName);
    		agent.setUser_name(dto.userName);
    		agent.setPassword(dto.password);
    		agent.setEmail(dto.email);
    		agent.setActive(dto.active);
    		agent.setInserted_date(dto.insertedDate);
    		agent.setPhone(dto.phone);
    	
    	}
    	
    	@Override
    	public void mapEntityToDto(Agent agent,AgentDto dto){
    		dto.agentId = agent.getAgent_id();
    		dto.firstName = agent.getFirst_name();
    		dto.lastName = agent.getLast_name();
    		dto.userName = agent.getUser_name();
    		dto.password = agent.getPassword();
    		dto.email = agent.getEmail();
    		dto.active = agent.getActive();
    		dto.insertedDate = agent.getInserted_date();
    		dto.phone = agent.getPhone();
    		dto.id = agent.getId().toString();
    	}
		
	}
}
