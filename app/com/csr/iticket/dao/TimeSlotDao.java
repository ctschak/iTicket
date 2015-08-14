package com.csr.iticket.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import play.Logger;

import com.csr.iticket.entities.mongo.Customer;
import com.csr.iticket.entities.mongo.SlotBooking;
import com.csr.iticket.framework.MorphiaObject;

@Component
public class TimeSlotDao {
	
	public void saveOrUpdateSlotBooking(SlotBooking booking) {
		SlotBooking retrive = MorphiaObject.datastore.find(SlotBooking.class)
				.field("slot_booking_id").equal(booking.getSlot_booking_id()).get();
		if (retrive == null) {
			MorphiaObject.datastore.save(booking);
		}else{
			booking.setId(retrive.getId());
			MorphiaObject.datastore.save(booking);
		}	
	}
	
	public List<SlotBooking> findAll() {
		Logger.debug("** CustomerDao findAll**"+MorphiaObject.datastore); 
		if (MorphiaObject.datastore != null) {
			Logger.debug("Invoke	"+MorphiaObject.datastore.find(SlotBooking.class).asList());
			return MorphiaObject.datastore.find(SlotBooking.class).asList();
		}
		return new ArrayList<SlotBooking>();
	}

}
