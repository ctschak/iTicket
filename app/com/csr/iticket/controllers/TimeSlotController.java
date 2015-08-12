package com.csr.iticket.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import play.api.mvc.Controller;
import play.libs.Json;









import com.csr.iticket.dto.mongo.SlotBookingDto;
import com.csr.iticket.entities.mongo.Item;
import com.csr.iticket.services.TimeSlotService;
import com.csr.iticket.structure.TimeSlotInfo;
import com.csr.iticket.util.DateUtil;
import com.csr.iticket.util.FunctionalUtil.TimeSlotUtil;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.mvc.Result;


@Component
public class TimeSlotController extends play.mvc.Controller {
	
	@Autowired
	TimeSlotService timeSlotService;
	
	/**
	 * 
	 * @return
	 */
	public Result getCurrentTimeSlotInfo() {
		Integer currentHour = DateUtil.getCurrentHour();
		String currentSlot = TimeSlotUtil.identifyTheSlot(currentHour);
		TimeSlotInfo t = new TimeSlotInfo();
		t.setCurrentTime(currentHour.toString());
		t.setSlotInfo(currentSlot);
		JsonNode timeslot = Json.toJson(t);
		ObjectNode result = Json.newObject();
		result.put("slotavinfo", timeslot);
		return ok(Json.toJson(result));	
	}
	
	/**?
	 * 
	 * @return
	 */
	public Result slotBookItem(){
	System.out.println("i am in slotBookingitem");
	Integer currentHour = DateUtil.getCurrentHour();
	String currentSlot = TimeSlotUtil.identifyTheSlot(currentHour);
	Date d = new Date();
	
	//Generate Items
	List<Item> items = new ArrayList<Item>();
	Item item = new Item();
	item.setBookedTime(currentSlot);
	items.add(item);

	// Populate booking dto
	SlotBookingDto slotBookingDto = new SlotBookingDto();
	slotBookingDto.booking_time_from = currentSlot;
	slotBookingDto.booking_time_to = currentSlot;
	slotBookingDto.slot_date = d.toString();
	slotBookingDto.items = items;
	
	// call service	
	 
	timeSlotService.bookingStore(slotBookingDto);
	 
	return ok();	
	}
	
	
	

}
