package mrd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	private static SimpleDateFormat standardDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	public static String formatDate(Date d) {
		if(d == null) return null;

		return standardDateFormatter.format(d);
	}
	
	/**
	 * 
	 * @param d The date to be formatted
	 * @param format String representing the desired output format<BR><BR>
	 * 
	 * <table border=1>
	 * 	<TR><TD>Letter</TD><TD>Date or Time Component</TD><TD>Presentation</TD><TD>Examples</TD></TR>
	 *  <TR><TD>G</TD><TD>Era designator</TD><TD>Text</TD><TD>AD  </TD></TR>
	 *  <TR><TD>y</TD><TD>Year</TD><TD>Year</TD><TD>1996; 96  </TD></TR>
	 *  <TR><TD>M</TD><TD>Month in year</TD><TD>Month</TD><TD>July; Jul; 07</TD></TR>
	 *	<TR><TD>w</TD><TD>Week in year</TD><TD>Number</TD><TD>27  </TD></TR>
	 *  <TR><TD>W</TD><TD>Week in month</TD><TD>Number</TD><TD>2  </TD></TR>
	 *  <TR><TD>D</TD><TD>Day in year</TD><TD>Number</TD><TD>189  </TD></TR>
	 *  <TR><TD>d</TD><TD>Day in month</TD><TD>Number</TD><TD>10  </TD></TR>
	 *  <TR><TD>F</TD><TD>Day of week in month</TD><TD>Number</TD><TD>2  </TD></TR>
	 *  <TR><TD>E</TD><TD>Day in week</TD><TD>Text</TD><TD>Tuesday; Tue  </TD></TR>
	 *  <TR><TD>a</TD><TD>Am/pm marker</TD><TD>Text</TD><TD>PM  </TD></TR>
	 *  <TR><TD>H</TD><TD>Hour in day (0-23)</TD><TD>Number</TD><TD>0  </TD></TR>
	 *  <TR><TD>k</TD><TD>Hour in day (1-24)</TD><TD>Number</TD><TD>24  </TD></TR>
	 *  <TR><TD>K</TD><TD>Hour in am/pm (0-11)</TD><TD>Number</TD><TD>0  </TD></TR>
	 *  <TR><TD>h</TD><TD>Hour in am/pm (1-12)</TD><TD>Number</TD><TD>12  </TD></TR>
	 *  <TR><TD>m</TD><TD>Minute in hour</TD><TD>Number</TD><TD>30  </TD></TR>
	 *  <TR><TD>s</TD><TD>Second in minute</TD><TD>Number</TD><TD>55  </TD></TR>
	 *  <TR><TD>S</TD><TD>Millisecond</TD><TD>Number</TD><TD>978  </TD></TR>
	 *  <TR><TD>z</TD><TD>Time zone</TD><TD>General time zone</TD><TD>Pacific Standard Time; PST; GMT-08:00</TD></TR>
	 *  <TR><TD>Z</TD><TD>Time zone</TD><TD>RFC 822 time zone</TD><TD>-0800  </TD></TR>
	 *  </table>
	 * 
	 * @return The formatted date
	 */
	public static String formatDate(Date d, String format) {
		if(d == null) return null;
		if(format == null) return null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
	
	/**
	 * 
	 * @param d The date to be formatted
	 * @return The given date formatted as dd-MMM-yyyy (e.g. 15-Apr-2010)
	 */
	public static String formatDateForDatabase(Date d) {
		return formatDate(d, "dd-MMM-yyyy");
	}
	
	/**
	 * 
	 * @param date String representation of a date
	 * @param format A standard java date format representing the date given as a parameter.
	 * @return The represented date
	 * @throws ParseException
	 */
	public static java.sql.Date getDate(String date, String format) throws ParseException {
		if(date == null) return null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return (java.sql.Date) sdf.parse(date);
	}

	/**
	 * 
	 * @return The current date-time in the format yyMMddHHmmss
	 */
	public static String ts() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		return sdf.format(new Date());
	}

	/**
	 * 
	 * @return The current date time formatted with dd-MMM-yyyy
	 */
	public static String now() {
		return formatDate(new Date());
	}

	/**
	 * 
	 * @param eightDigitDate A Number representing a date in the format yyyyMMdd (e.g. 20100415 = April 15, 2010)
	 * @return A date
	 */
	public static java.sql.Date getDate(Number eightDigitDate) {
		if(eightDigitDate == null) return null;
		
		String sEightDigitDate = "" + eightDigitDate.intValue() + "";
				
		String yr = sEightDigitDate.substring(0,4);
		String mo = sEightDigitDate.substring(4,6);
		String dy = sEightDigitDate.substring(6);
		
		return java.sql.Date.valueOf(yr + "-" + mo + "-" + dy);
	}

	public static java.sql.Date getDate(Number century, Number year, Number month, Number day) {
		if(century == null || year == null || month == null || day == null) return null;
		String yr = "" + ((century.intValue() * 100) + year.intValue());
		String mo = (month.intValue() <= 9 ? "0" : "") + month.intValue();
                String dy = (day.intValue() <= 9 ? "0" : "") + day.intValue();
		return java.sql.Date.valueOf(yr + "-" + mo + "-" + dy);
	}

	public static java.sql.Date getDate(Number fourDigitYear, Number month, Number day) {
		if(fourDigitYear == null || month == null || day == null) return null;
		String yr = "" + fourDigitYear.intValue();
		String mo = (month.intValue() <= 9 ? "0" : "") + month.intValue();
                String dy = (day.intValue() <= 9 ? "0" : "") + day.intValue();
		return java.sql.Date.valueOf(yr + "-" + mo + "-" + dy);
	}

	/**
	 * 
	 * @return The current Date/Time
	 */
	public static java.sql.Date getCurrentDate() {
		java.util.Date d = new java.util.Date();
		return new java.sql.Date(d.getTime());
	}
	
	public static java.sql.Date addMonths(java.sql.Date date, int months) {
		Calendar c = date2calendar(date);
		c.add(Calendar.MONTH, months);
		return new java.sql.Date(c.getTimeInMillis());
	}
	
	@SuppressWarnings("deprecation")
	public static Calendar date2calendar(java.sql.Date date) {
		Calendar cal = new GregorianCalendar(date.getYear() + 1900, date.getMonth(), date.getDate());
		return cal;
	}
	
	@SuppressWarnings("deprecation")
	public static int date2integer(java.sql.Date date) {
		return ((date.getYear() + 1900) * 10000) + ((date.getMonth() + 1) * 100) + date.getDate();
	}
	
	
	public static int getLtmStartPeriod(int ltmEndPeriod) {
		int endPeriod = ltmEndPeriod * 100 + 1;
		java.sql.Date endDate = DateUtils.getDate(endPeriod);
		java.sql.Date startDate = DateUtils.addMonths(endDate, -11);
		return DateUtils.date2integer(startDate) / 100;
	}
	
	public static int getPreviousPeriod(int period) {
		java.sql.Date date = DateUtils.getDate((period * 100 + 1));
		java.sql.Date newDate = DateUtils.addMonths(date, -1);
		return DateUtils.date2integer(newDate) / 100;
	}
	

	public static int getNextPeriod(int period) {
		java.sql.Date date = DateUtils.getDate((period * 100 + 1));
		java.sql.Date newDate = DateUtils.addMonths(date, 1);
		return DateUtils.date2integer(newDate) / 100;
	}
	
	public static java.sql.Date toDate(java.sql.Timestamp timestamp) {
	    long milliseconds = timestamp.getTime() + (timestamp.getNanos() / 1000000);
	    return new java.sql.Date(milliseconds);
	}
	
	/**
	 * 
	 * @param periodFrom The first period in the range
	 * @param periodTo The last period in the range
	 * @return The number of periods within the range including the first and last.
	 */
	public static int getPeriodRangeSize(int periodFrom, int periodTo) {
		int rslt = 0;
		int curPeriod = periodFrom;
		
		while(curPeriod <= periodTo) {
			rslt++;
			curPeriod = getNextPeriod(curPeriod);
		}
		
		
		return rslt;
	}
}
