package mrd.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateUtilsTest  {

        public DateUtilsTest() { System.out.print(this.getClass().getCanonicalName() + "."); }
	@SuppressWarnings("deprecation")
	@Test
	public void testGetDateNumber() {
            System.out.println("getDate(number)");
		java.sql.Date expected = new java.sql.Date(72, 1, 15); // 2/15/1972
		java.sql.Date actual = DateUtils.getDate(19720215);
		assertEquals(expected, actual);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetDateNumberNumberNumberNumber() {
            System.out.println("getDate(number,number,number,number)");
		java.sql.Date expected = new java.sql.Date(72, 1, 15); // 2/15/1972
		java.sql.Date actual = DateUtils.getDate(19, 72, 2, 15);
		assertEquals(expected, actual);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetDateNumberNumberNumber() {
            System.out.println("getDate(number,number,number)");
		java.sql.Date expected = new java.sql.Date(72, 1, 15); // 2/15/1972
		java.sql.Date actual = DateUtils.getDate(1972, 2, 15);
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAddMonthsZero() {
		System.out.println("addMonths(0)");
		java.sql.Date expected = new java.sql.Date(72, 1, 15); // 2/15/1972
		java.sql.Date actual = DateUtils.addMonths(new java.sql.Date(72, 1, 15),0);	// should be the same
		
		assertEquals(expected, actual);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddMonths() {
		System.out.println("addMonths");
		java.sql.Date expected = new java.sql.Date(72, 1, 15); // 2/15/1972
		java.sql.Date actual = DateUtils.addMonths(new java.sql.Date(72, 0, 15),1);
		
		assertEquals(expected, actual);
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testDate2calendar() {
            System.out.println("date2calendar");
		Calendar expected = new GregorianCalendar(1972, 1, 15);
		Calendar actual = DateUtils.date2calendar(new java.sql.Date(72,1,15));
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDate2integer() {
            System.out.println("date2integer");
		int expected = 19720215;
		int actual = DateUtils.date2integer(new java.sql.Date(72,1,15));
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetLtmStartPeriod() {
            System.out.println("getLtmStartPeriod");
		int expected = 200907;
		int startPeriod = 201006;
		int actual = DateUtils.getLtmStartPeriod(startPeriod);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetPreviousPeriod() {
                System.out.println("getPreviousPeriod");
		int original = 201006;
		int expected = 201005;
		int actual = DateUtils.getPreviousPeriod(original);
		
		assertEquals(expected, actual);
	}

}
