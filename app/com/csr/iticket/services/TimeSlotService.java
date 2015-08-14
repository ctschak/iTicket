package com.csr.iticket.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.csr.iticket.dto.mongo.SlotBookingDto;
import com.csr.iticket.entities.mongo.SlotBooking;

public interface TimeSlotService {
	
	public void bookingStore(SlotBookingDto slotBookingDto);
	
	public  List<SlotBooking> getBookingList();
	
}
