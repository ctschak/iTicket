package com.csr.iticket.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import play.Logger;

import com.csr.iticket.entities.mongo.Agent;
import com.csr.iticket.framework.MorphiaObject;
import com.google.code.morphia.query.Query;

@Component
public class AgentDao {
	public List<Agent> findAll() {
		Logger.debug("** AgentDao findAll**"+MorphiaObject.datastore); 
		if (MorphiaObject.datastore != null) {
			Logger.debug("Invoke	"+MorphiaObject.datastore.find(Agent.class).asList());
			return MorphiaObject.datastore.find(Agent.class).asList();
		}
		return new ArrayList<Agent>();
	}
	
	public Agent validateLogin(String id, String pass){
		if (MorphiaObject.datastore != null) {
			Query<Agent> q = MorphiaObject.datastore.createQuery(Agent.class);
			q.field("user_name").equal(id);
			q.field("password").equal(pass);
			
			return q.get();
		}
		return null;
	}
	
	public Agent findById(int id){
		if (MorphiaObject.datastore != null) {
			return MorphiaObject.datastore.find(Agent.class, "agent_id", id).get();
		}
		return null;
	}
}
