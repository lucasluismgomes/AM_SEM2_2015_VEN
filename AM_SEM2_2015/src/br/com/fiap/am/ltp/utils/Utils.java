package br.com.fiap.am.ltp.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Métodos para conversões e outras funções uteís.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Utils {
	/**
	 * Faz a conversão de um Date para Calendar.
	 * 
	 * @author Lucas 74795
	 * @param date
	 * 			A data que será convertida para Calendar.
	 * @return <code>cal</code> A data em formato Calendar.
	 */
	public static Calendar DateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * Faz a formatação de um Calendar para mostrar dia, mês e ano.
	 * 
	 * @author Mateus
	 * @since 1.0
	 * @param c
	 * 			A data que será formatada.
	 * @return <code>df.format(c.getTime())</code> A data formatada.
	 */
	public static String formatarCalendar(Calendar c) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(c.getTime());
	}
}
