package mrd.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

import mrd.util.DateUtils;

public class RecordPrintableTest  {
    public RecordPrintableTest() { System.out.print(this.getClass().getCanonicalName() + "."); }

	/*
	@Before
	public void setUp() throws Exception {
	}
	 */
	
	@Test
	public void testGetName() {
		System.out.println("getName");
		String expected = "TEST RECORD";
		Record record = new TestRecord(expected);
		RecordPrintable p = new RecordPrintable(record);
		String actual = p.getName();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFields() {
                System.out.println("getFields");
		RecordPrintable p = new RecordPrintable(new TestRecord("TEST RECORD"));
		List <String> actual = p.getFields();
		
		List<String> expected = new ArrayList <String> ();
		expected.add("FIELD1");
		expected.add("FIELD2");
		expected.add("FIELD3");
		expected.add("FIELD4");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testGetValues_0() {
                System.out.println("getValues 0");
		RecordPrintable p = new RecordPrintable(new TestRecord("TEST RECORD"));
		List <Object> actual = p.getValues();
		
		List<String> expected = new ArrayList <String> ();
		expected.add(null);
		expected.add(null);
		expected.add(null);
		expected.add(null);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetValues_1() {
                System.out.println("getValues 1");
                Date d = DateUtils.getCurrentDate();
		RecordPrintable p = new RecordPrintable(new TestRecord("TEST RECORD", "TEST VALUE", 1.0, 2, d));
		List <Object> actual = p.getValues();
		
		List<Object> expected = new ArrayList <Object> ();
		expected.add("TEST VALUE");
		expected.add(1.0);
		expected.add(2);
		expected.add(d);
		
		assertEquals(expected, actual);
	}
}
