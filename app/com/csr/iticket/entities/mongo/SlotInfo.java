package com.csr.iticket.entities.mongo;

import java.util.Date;

import org.bson.types.ObjectId;

import play.data.validation.Constraints.Required;

import com.google.code.morphia.annotations.Id;

public class SlotInfo {
	
	@Id
	public ObjectId id;
	public Integer slot_info_id;	
	@Required
	public String slot_name;	
	@Required
	public Date time_from;	
	@Required
	public Date time_to;
	
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public Integer getSlot_info_id() {
		return slot_info_id;
	}
	public void setSlot_info_id(Integer slot_info_id) {
		this.slot_info_id = slot_info_id;
	}
	public String getSlot_name() {
		return slot_name;
	}
	public void setSlot_name(String slot_name) {
		this.slot_name = slot_name;
	}
	public Date getTime_from() {
		return time_from;
	}
	public void setTime_from(Date time_from) {
		this.time_from = time_from;
	}
	public Date getTime_to() {
		return time_to;
	}
	public void setTime_to(Date time_to) {
		this.time_to = time_to;
	}
	
	
	
	

}
