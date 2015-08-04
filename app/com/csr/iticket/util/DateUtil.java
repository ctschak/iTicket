package com.csr.iticket.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static int getCurrentHour(){
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.HOUR_OF_DAY);		
	}

}
