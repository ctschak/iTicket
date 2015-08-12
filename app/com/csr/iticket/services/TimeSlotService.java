package com.csr.iticket.services;

import org.springframework.stereotype.Component;

import com.csr.iticket.dto.mongo.SlotBookingDto;

public interface TimeSlotService {
	
	public void bookingStore(SlotBookingDto slotBookingDto);
	
}
