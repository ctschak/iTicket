package com.csr.iticket.dto.mongo;

import java.util.List;
import org.springframework.stereotype.Component;
import com.csr.iticket.dto.DtoMapper;
import com.csr.iticket.entities.mongo.Item;
import com.csr.iticket.entities.mongo.SlotBooking;

public class SlotBookingDto {
	
	public String id;
	public Integer slot_booking_id;
	public String slot_date;
	public String booking_time_from;
	public String booking_time_to;
	public List<Item> items;
	
	@Component
    public static class Mapper extends DtoMapper<SlotBooking,SlotBookingDto>{

		@Override
		protected SlotBookingDto newDto() {
			// TODO Auto-generated method stub
			return new SlotBookingDto();
		}

		@Override
		public void mapEntityToDto(SlotBooking entity, SlotBookingDto dto) {
			// TODO Auto-generated method stub
			dto.id = entity.id.toString();
			dto.booking_time_from =  entity.booking_time_from;
			dto.booking_time_to =  entity.booking_time_to;
			dto.slot_booking_id = entity.slot_booking_id;
			dto.slot_date = entity.slot_date;
			dto.items = entity.items;
			
		}
		
		public SlotBooking newEntityFormation(SlotBookingDto dto){
			SlotBooking entity = new SlotBooking();
			mapDtoToEntity(dto, entity);
			return entity;
		}
		
		public void mapDtoToEntity(SlotBookingDto dto, SlotBooking entity){
			entity.setSlot_booking_id(dto.slot_booking_id);
			entity.setBooking_time_from(dto.booking_time_from);
			entity.setBooking_time_to(dto.booking_time_to);
			entity.setSlot_date(dto.slot_date);
			entity.setItems(dto.items);
			
		}
		
	}

}
