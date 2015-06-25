package com.csr.iticket.entities.mongo;

import org.bson.types.ObjectId;

import play.data.validation.Constraints.Required;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Customer {
	
	@Id
	public ObjectId id;
	public Integer customer_id;
	@Required
	public String first_name;
	@Required
	public String last_name;
	@Required
	public String email;
	public Integer active;
	public String inserted_date;
	public String phone;
	@Required
	public Integer ticket_id;
	@Required
	public String issue_description;

	public String ticket_comments;
	@Required
	public Integer agent_id;
	@Required
	public Integer assigned_to;
	@Required
	public String status;
	
	
	
	public Integer getTicket_id() {
		return ticket_id;
	}


	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}


	public String getTicket_comments() {
		return ticket_comments;
	}


	public void setTicket_comments(String ticket_comments) {
		this.ticket_comments = ticket_comments;
	}


	public Integer getAgent_id() {
		return agent_id;
	}


	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}


	public Integer getAssigned_to() {
		return assigned_to;
	}


	public void setAssigned_to(Integer assigned_to) {
		this.assigned_to = assigned_to;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}



	
	
	
	
	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public Integer getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getActive() {
		return active;
	}


	public void setActive(Integer active) {
		this.active = active;
	}


	public String getInserted_date() {
		return inserted_date;
	}


	public void setInserted_date(String inserted_date) {
		this.inserted_date = inserted_date;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIssue_description() {
		return issue_description;
	}


	public void setIssue_description(String issue_description) {
		this.issue_description = issue_description;
	}



	
  @Override
  public String toString() {
    return customer_id + ":" + first_name;
  }

}
