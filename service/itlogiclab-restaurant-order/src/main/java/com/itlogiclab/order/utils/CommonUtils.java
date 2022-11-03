package com.itlogiclab.order.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonUtils {
	private static Logger logger = LogManager.getLogger(CommonUtils.class);
	
	public static String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = formatter.format(Calendar.getInstance().getTime());
		return formattedDate;
	}
	
	
	public static String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = formatter.format(Calendar.getInstance().getTime());
		return formattedDate;
	}

}
