package mrd.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest  {
    public StringUtilsTest() { System.out.print(this.getClass().getCanonicalName() + "."); }

	@Test
	public void testRepeat() {
            System.out.println("repeat");
		String expected = "XXXXX";
		String actual = StringUtils.repeat("X", 5);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRepeat_null() {
            System.out.println("repeat null");
		String expected = "     ";
		String actual = StringUtils.repeat(null, 5);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testPadLeftStringIntString() {
            System.out.println("padLeft(string, int, string)");
		String expected = "XXXXX01234";
		String actual = StringUtils.padLeft("01234", 10,'X');
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPadLeftStringIntString_null() {
            System.out.println("padLeft(null, int, string)");
		String expected = "XXXXXXXXXX";
		String actual = StringUtils.padLeft(null, 10,'X');
		
		assertEquals(expected, actual);
	}

	@Test
	public void testPadLeftStringInt() {
            System.out.println("padLeft(string, int)");
		String expected = "     01234";
		String actual = StringUtils.padLeft("01234", 10);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPadLeftStringInt_null() {
            System.out.println("padLeft(null, int)");
		String expected = "          ";
		String actual = StringUtils.padLeft(null, 10);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testPadRightStringIntString() {
            System.out.println("padRight(string, int, string)");
		String expected = "01234XXXXX";
		String actual = StringUtils.padRight("01234", 10,'X');
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPadRightStringIntString_null() {
            System.out.println("padRight(null, int, string)");
		String expected = "XXXXXXXXXX";
		String actual = StringUtils.padRight(null, 10,'X');
		
		assertEquals(expected, actual);
	}

	@Test
	public void testPadRightStringInt() {
            System.out.println("padRight(string, int)");
		String expected = "01234     ";
		String actual = StringUtils.padRight("01234", 10);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPadRightStringInt_null() {
            System.out.println("padRight(null, int)");
		String expected = "          ";
		String actual = StringUtils.padRight(null, 10);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testContains_StringString_1() {
            System.out.println("contains(string,string)");
		String needle = "NEEDLE";
		String haystack = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
			
		assertTrue(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringString_2() {
            System.out.println("contains(null,string)");
		String needle = null;
		String haystack = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
			
		assertTrue(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringString_3() {
            System.out.println("contains(string,null)");
		String needle = "NEEDLE";
		String haystack = null;
			
		assertFalse(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringString_4() {
            System.out.println("contains(null,null)");
		String needle = null;
		String haystack = null;
			
		assertTrue(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringString_5() {
            System.out.println("contains(string,string) false");
		String needle = "I'M NOT IN THE STRING";
		String haystack = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
			
		assertFalse(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringArrayString_1() {
            System.out.println("contains(array,string)");
		String needle[] = {"QUEST","NEEDLE"};
		String haystack = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
			
		assertTrue(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringArrayString_2() {
            System.out.println("contains(null array,string)");
		String needle[] = null;
		String haystack = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
			
		assertFalse(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringArrayString_3() {
            System.out.println("contains(array,null)");
		String needle[] = {"QUEST","NEEDLE"};
		String haystack = null;
			
		assertFalse(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringArrayString_4() {
            System.out.println("contains(null array,null)");
		String needle[] = null;
		String haystack = null;
			
		assertTrue(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testContains_StringArrayString_5() {
            System.out.println("contains(array,string) false");
		String needle[] = {"EMPTY","STRING"};
		String haystack = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
			
		assertFalse(StringUtils.contains(needle, haystack));
	}
	
	@Test
	public void testIn_1() {
            System.out.println("in(string,array) true");
		String needle = "NEEDLE";
		String haystack[] = new String[] {"THE","QUEST","TO","FIND","A","NEEDLE","IN","A","HAYSTACK"};
		
		assertTrue(StringUtils.in(needle, haystack));
	}
	
	@Test
	public void testIn_2() {
            System.out.println("in(string,array) false");
		String needle = "COW";
		String haystack[] = new String[] {"THE","QUEST","TO","FIND","A","NEEDLE","IN","A","HAYSTACK"};
		
		assertFalse(StringUtils.in(needle, haystack));
	}
	
	@Test
	public void testIn_3() {
            System.out.println("in(null string,array)");
		String needle = null;
		String haystack[] = new String[] {"THE","QUEST","TO","FIND","A","NEEDLE","IN","A","HAYSTACK"};
		
		assertFalse(StringUtils.in(needle, haystack));
	}
	
	@Test
	public void testIn_4() {
            System.out.println("in(string,null array)");
		String needle = "NEEDLE";
		String haystack[] = null;
		
		assertFalse(StringUtils.in(needle, haystack));
	}
	
	@Test
	public void testIn_5() {
            System.out.println("in(null string,null array)");
		String needle = null;
		String haystack[] = null;
		
		assertTrue(StringUtils.in(needle, haystack));
	}

	@Test
	public void testMatches_1() {
            System.out.println("matches(string,array) regex true");
		String searchString = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
		String patterns[] = new String[] {"NEEDLE.*HAYSTACK"};
		
		assertTrue(StringUtils.matches(patterns, searchString));
	}
	
	@Test
	public void testMatches_2() {
            System.out.println("matches(string,array) regex false");
		String searchString = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
		String patterns[] = new String[] {"COW.*DUCK"};
		
		assertFalse(StringUtils.matches(patterns, searchString));
	}
	
	@Test
	public void testMatches_3() {
            System.out.println("matches(null string,array)");
		String searchString = null;
		String patterns[] = new String[] {"NEEDLE.*HAYSTACK"};
		
		assertFalse(StringUtils.matches(patterns, searchString));
	}
	
	@Test
	public void testMatches_4() {
            System.out.println("matches(string,null array)");
		String searchString = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
		String patterns[] = null;
		
		assertFalse(StringUtils.matches(patterns, searchString));
	}
	
	@Test
	public void testMatches_5() {
            System.out.println("matches(null string, null array)");
		String searchString = null;
		String patterns[] = null;
		
		assertTrue(StringUtils.matches(patterns, searchString));
	}
	
	@Test
	public void testMatches_6() {
            System.out.println("matches(string,array) true");
		String searchString = "THE QUEST TO FIND A NEEDLE IN A HAYSTACK";
		String patterns[] = new String[] {"NEEDLE IN A HAYSTACK"};
		
		assertTrue(StringUtils.matches(patterns, searchString));
	}
	
	@Test
	public void testMatches_7() {
            System.out.println("matches(string,string) true");
		String searchString = "UH70100";
		String pattern = "UH7";
		
		assertTrue(StringUtils.matches(pattern, searchString));
	}
	
	@Test
	public void testArray2string_1() {
            System.out.println("array2string");
		String array[] = new String[] {"1","2","3","4","5"};
		String expected = "1,2,3,4,5";
		String actual = StringUtils.array2string(array);
		
		assertEquals(expected, actual);
	}
}
