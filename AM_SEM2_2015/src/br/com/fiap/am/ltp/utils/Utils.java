package br.com.fiap.am.ltp.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * M�todos para convers�es e outras fun��es ute�s.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Utils {
	public static Calendar DateToCalendar(Date date){ 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	public static String formatarCalendar(Calendar c)
	{
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(c.getTime());
	}
}
