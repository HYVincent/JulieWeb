
package com.vincent.julie.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: DateUtils.java
 * @Package com.vincent.julie.utils
 * @author: Vinent QQ:1032006226
 * @version V1.0
 * @Copyright: 2018
 */
public class DateUtils {

	/**
	 * @param time "HH:mm:ss"
	 * @return
	 */
	public static long getTimeMillis(String time) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
			Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
			return curDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
