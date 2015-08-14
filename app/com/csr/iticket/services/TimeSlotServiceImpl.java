package com.csr.iticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csr.iticket.dao.TimeSlotDao;
import com.csr.iticket.dto.DtoMapper;
import com.csr.iticket.dto.mongo.SlotBookingDto;
import com.csr.iticket.entities.mongo.SlotBooking;
@Component
public class TimeSlotServiceImpl implements TimeSlotService {

	
	@Autowired
	TimeSlotDao timeSlotDao;
	
	@Autowired
	SlotBookingDto.Mapper mapper;
	
	@Override
	public void bookingStore(SlotBookingDto slotBookingDto) {
		// TODO Auto-generated method stub
		timeSlotDao.saveOrUpdateSlotBooking(mapper.newEntityFormation(slotBookingDto));
	}
	
	public List<SlotBooking> getBookingList(){
		return timeSlotDao.findAll();
	}

}
