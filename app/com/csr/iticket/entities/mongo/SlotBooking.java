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
	public Integer slot_booking_id;
	@Required
	public String slot_date;
	@Required
	public String booking_time_from;
	@Required
	public String booking_time_to;
	@Required
	public List<Item> items;
	
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public Integer getSlot_booking_id() {
		return slot_booking_id;
	}
	public void setSlot_booking_id(Integer slot_booking_id) {
		this.slot_booking_id = slot_booking_id;
	}
	public String getSlot_date() {
		return slot_date;
	}
	public void setSlot_date(String slot_date) {
		this.slot_date = slot_date;
	}
	
	public String getBooking_time_from() {
		return booking_time_from;
	}
	public void setBooking_time_from(String booking_time_from) {
		this.booking_time_from = booking_time_from;
	}
	public String getBooking_time_to() {
		return booking_time_to;
	}
	public void setBooking_time_to(String booking_time_to) {
		this.booking_time_to = booking_time_to;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	

}
