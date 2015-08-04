package com.csr.iticket.entities.mongo;
import java.util.List;
import org.bson.types.ObjectId;
import play.data.validation.Constraints.Required;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class SlotBooking {
	
	
	@Id
	public ObjectId id;
	public Integer slot_id;
	@Required
	public String slot_date;
	@Required
	public String time_from;
	@Required
	public String time_to;
	@Required
	public List<Item> items;
	
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public Integer getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(Integer slot_id) {
		this.slot_id = slot_id;
	}
	public String getSlot_date() {
		return slot_date;
	}
	public void setSlot_date(String slot_date) {
		this.slot_date = slot_date;
	}
	public String getTime_from() {
		return time_from;
	}
	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}
	public String getTime_to() {
		return time_to;
	}
	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	

}
