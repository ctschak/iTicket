package com.csr.iticket.controllers;

import java.util.Date;

import org.springframework.stereotype.Component;

import play.libs.Json;


import com.csr.iticket.structure.TimeSlotInfo;
import com.csr.iticket.util.DateUtil;
import com.csr.iticket.util.FunctionalUtil.TimeSlotUtil;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.mvc.Result;


@Component
public class TimeSlotController {
	
	/**
	 * 
	 * @return
	 */
	public Result getCurrentTimeSlotInfo() {
		/*Integer currentHour = DateUtil.getCurrentHour();
		String currentSlot = TimeSlotUtil.identifyTheSlot(currentHour);
		TimeSlotInfo t = new TimeSlotInfo();
		t.setCurrentTime(currentHour.toString());
		t.setSlotInfo(currentSlot);
		JsonNode timeslot = Json.toJson(t);*/
		//ObjectNode result = Json.newObject();
		//result.put("slotavinfo", timeslot);
		
		ObjectNode result = Json.newObject();
	    result.put("exampleField1", "foobar");
	    result.put("exampleField2", "Hello world!");
	    return ok(result);

	}

}
