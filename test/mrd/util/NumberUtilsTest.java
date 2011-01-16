package mrd.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Vector;

import org.junit.Test;
import static org.junit.Assert.*;


public class NumberUtilsTest {
        public NumberUtilsTest() { System.out.print(this.getClass().getCanonicalName() + "."); }

	@Test
	public void testRoundBigDecimalInt_gt0() {
            System.out.println("round(BigDecimal > 0)");
		BigDecimal original = new BigDecimal(1.12341111);
		BigDecimal expected =  new BigDecimal(1.1234, new MathContext(5));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_gt10() {
            System.out.println("round(BigDecimal > 10)");
		BigDecimal original = new BigDecimal(10.12341111);
		BigDecimal expected =  new BigDecimal(10.1234, new MathContext(6));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_lt0() {
            System.out.println("round(BigDecimal < 0)");
		BigDecimal original = new BigDecimal(0.12341111);
		BigDecimal expected =  new BigDecimal(0.1234, new MathContext(4));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_lt00() {
            System.out.println("round(BigDecimal < 0.00)");
		BigDecimal original = new BigDecimal(0.012341111);
		BigDecimal expected =  new BigDecimal(0.0123, new MathContext(3));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}

	//
	
	@Test
	public void testRoundBigDecimalInt_gt0n() {
            System.out.println("round(BigDecimal < 0)");
		BigDecimal original = new BigDecimal(-1.12341111);
		BigDecimal expected =  new BigDecimal(-1.1234, new MathContext(5));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_gt10n() {
            System.out.println("round(BigDecimal < -10)");
		BigDecimal original = new BigDecimal(-10.12341111);
		BigDecimal expected =  new BigDecimal(-10.1234, new MathContext(6));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_lt0n() {
            System.out.println("round(BigDecimal < 0)");
		BigDecimal original = new BigDecimal(-0.12341111);
		BigDecimal expected = new BigDecimal(-0.1234, new MathContext(4));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_lt00n() {
            System.out.println("round(-1 < BigDecimal < 0");
		BigDecimal original = new BigDecimal(-0.012341111);
		BigDecimal expected = new BigDecimal(-0.0123, new MathContext(3));
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_null() {
            System.out.println("round(null)");
		BigDecimal actual = NumberUtils.round(null, 4);
		
		assertNull(actual);
	}
	
	@Test
	public void testRoundBigDecimalInt_0() {
            System.out.println("round(BigDecimal = 0)");
		BigDecimal original = new BigDecimal(0);
		BigDecimal expected =  (new BigDecimal(0.0000)).setScale(4);
		BigDecimal actual = NumberUtils.round(original, 4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMean_0() {
            System.out.println("mean #0");
		Vector <Number> v = new Vector <Number> ();
		v.add(new BigDecimal(1));
		v.add(new BigDecimal(2));
		v.add(new BigDecimal(3));
		
		Number expected =  new Double(2);
		Number actual = NumberUtils.mean(v);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMean_1() {
            System.out.println("mean #1");
		Vector <Number> v = new Vector <Number> ();
		v.add(new BigDecimal(0));
		v.add(new BigDecimal(0));
		v.add(new BigDecimal(0));
		
		Number expected =  new Double(0);
		Number actual = NumberUtils.mean(v);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMean_2() {
            System.out.println("mean #2");
		Vector <Number> v = new Vector <Number> ();
		
		Number expected =  null;
		Number actual = NumberUtils.mean(v);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMean_3() {
            System.out.println("mean #3");
		Vector <Number> v = new Vector <Number> ();
		v.add(new BigDecimal(1));
		v.add(null);
		v.add(new BigDecimal(3));
		
		Number expected =  new Double(2);
		Number actual = NumberUtils.mean(v);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testStandardDeviation_0() {
            System.out.println("standardDeviation #0");
		Vector <Number> v = new Vector <Number> ();
		v.add(new BigDecimal(1));
		v.add(new BigDecimal(2));
		v.add(new BigDecimal(3));
		v.add(new BigDecimal(4));
		v.add(new BigDecimal(5));
		
		Number expected =  new Double(1.5811388300841898);
		Number actual = NumberUtils.standardDeviation(v).doubleValue();
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCorrelation_0() {
            System.out.println("correlation #0");
		Vector <Point> v = new Vector <Point> ();
		v.add(new Point(1.21,2.44));
		v.add(new Point(2.24,5.73));
		v.add(new Point(1.20,2.93));
		v.add(new Point(2.39,5.69));
		v.add(new Point(1.10,2.74));
		v.add(new Point(1.45,4.26));
		v.add(new Point(2.29,5.11));
		v.add(new Point(2.33,5.58));
		v.add(new Point(1.13,2.42));
		v.add(new Point(2.39,5.52));
		
		Number expected =  new Double(0.9668834368640391);
		Number actual = NumberUtils.correlation(v);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetHundreds() {
            System.out.println("getHundreds");
		Number original = new Double(2345.2345);
		String expected = "23.452345";
		String actual = "" + NumberUtils.round(NumberUtils.getHundreds(original),6);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetThousands() {
            System.out.println("getThousands");
		Number original = new Double(2342.3456);
		String expected = "2.3423456";
		String actual = "" + NumberUtils.round(NumberUtils.getThousands(original),7);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetMillions() {
             System.out.println("getMillions");
		Number original = new Double(23456789);
		String expected = "23.456789";
		String actual = "" + NumberUtils.round(NumberUtils.getMillions(original),6);
		
		assertEquals(expected, actual);
		
	}
}
