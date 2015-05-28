package com.vatan.shop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Date formate(Date date, String format) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			date = simpleDateFormat.parse(simpleDateFormat.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static Date dateIncrimentor(long requestDate, int incr) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(requestDate));
		calendar.add(Calendar.DATE, incr);
		Date date = calendar.getTime();
		return date;
	}
}
