package com.itlogiclab.payment.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class PaymentUtils {

	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = formatter.format(Calendar.getInstance().getTime());
		return formattedDate;
	}
	
}
