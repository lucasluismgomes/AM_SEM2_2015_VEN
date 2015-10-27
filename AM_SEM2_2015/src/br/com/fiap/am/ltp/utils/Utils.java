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
	/**
	 * Faz a convers�o de um Date para Calendar.
	 * 
	 * @author Lucas 74795
	 * @param date
	 * 			A data que ser� convertida para Calendar.
	 * @return <code>cal</code> A data em formato Calendar.
	 */
	public static Calendar DateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * Faz a formata��o de um Calendar para mostrar dia, m�s e ano.
	 * 
	 * @author Mateus
	 * @since 1.0
	 * @param c
	 * 			A data que ser� formatada.
	 * @return <code>df.format(c.getTime())</code> A data formatada.
	 */
	public static String formatarCalendar(Calendar c) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(c.getTime());
	}
}
