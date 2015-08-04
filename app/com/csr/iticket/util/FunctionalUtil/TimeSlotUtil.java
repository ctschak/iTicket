package com.csr.iticket.util.FunctionalUtil;

public class TimeSlotUtil {
	
	
	
	public static String identifyTheSlot(int slotHour) {
		String slot = "No Slot";
		switch (slotHour) {
		case (9): {
			slot = "slot1";
			break;
		}
		case 10: {
			slot = "slot1";
			break;
		}
		case 11: {
			slot = "slot2";
			break;
		}
		case 12: {
			slot = "slot2";
			break;
		}
		case 14: {
			slot = "slot3";
			break;
		}
		case 15: {
			slot = "slot3";
			break;
		}
		case 16: {
			slot = "slot3";
			break;
		}
		case 17: {
			slot = "slot4";
			break;
		}
		case 18: {
			slot = "slot4";
			break;
		}
		}

		return slot;
	}
	
	

}
