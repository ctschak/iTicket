package com.csr.iticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dao.AgentDao;
import com.csr.iticket.dto.mongo.AgentDto;
import com.csr.iticket.entities.mongo.Agent;
@Component
public class AgentServiceImpl implements AgentService{
	
	@Autowired
	AgentDao agentDao;
	
	@Autowired
	AgentDto.Mapper dtoMapper;

	@Override
	public AgentDto getAgent(int agentId) {
		Agent agent = agentDao.findById(agentId);
		return dtoMapper.fromEntity(agent);
	}

	@Override
	public List<AgentDto> getAllAgents() {
		List<Agent> agents= agentDao.findAll();
		return dtoMapper.fromEntities(agents);
	}

	@Override
	public AgentDto validateLogin(String username, String password) {
		Agent agent = agentDao.validateLogin(username, password);
		return dtoMapper.fromEntity(agent);
	}

}
