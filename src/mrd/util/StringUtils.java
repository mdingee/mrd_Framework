package mrd.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class StringUtils {

	/**
	 * Repeats a given string (s), n times.
	 * @param s The string to repeat
	 * @param n The number of times to repeat the string
	 * @return The given string (s) repeated n times
	 */
	public static String repeat(String s, int n) {
		String temp = (s == null ? " " : s);
		StringBuffer buf = new StringBuffer();
		buf.append("");
		
		for (int i = 0; i < n; ++i) {
			buf.append(temp);
		}
		
		return buf.toString();
	}

	public static String padLeft(String s, int n, char p) {
		String rslt = (s == null ? "" : s);
		
		while(rslt.length() < n) {
			rslt = p + rslt;
		}
		
		return rslt;
	}

	public static String padLeft(String s, int n) {
		String temp = (s == null ? "" : s);
	    return String.format("%1$#" + n + "s", temp);  
	}

	public static String padRight(String s, int n, char p) {

		StringBuffer buf = new StringBuffer();
		buf.append((s == null ? "" : s));
		
		while(buf.length() < n) {
			buf.append(p);
		}
		
		return buf.toString();
	}

	public static String padRight(String s, int n) {
		String temp = (s == null ? "" : s);
	    return String.format("%1$-" + n + "s", temp);  
	}

	/**
     * Tests to see if the needle exists in the haystack
     * @param needle
     * @param haystack
     * @return
     */
    public static boolean contains(String needle, String haystack) {
		if(needle == null && haystack == null) return true;
		if(needle == null) return true;
		if(haystack == null) return false;
		
		return haystack.trim().toUpperCase().contains(needle.toUpperCase());
	}
    
    /**
     * Tests to see if any of the "needle" values exist in the "haystack".
     * @param needle
     * @param haystack
     * @return
     */
    public static boolean contains(String needle[], String haystack) {
    	if(needle == null && haystack == null) return true;
    	if(needle == null) return false;
    	if(haystack == null) return false;
    	
		boolean rslt = false;
		
		for (int i = 0; !rslt && i < needle.length; i++) {
			if(contains(needle[i], haystack )) 
				rslt = true;
		}
		
		return rslt;
    }
    
    public static boolean in(String needle, String haystack[]) {
    	if(needle == null && haystack == null) return true;
    	if(needle == null) return false;
    	if(haystack == null) return false;
    	
    	boolean rslt = false;
    	
    	for(int i = 0; ! rslt && i < haystack.length; i++) {
    		if(needle.trim().toUpperCase().equals(haystack[i].trim().toUpperCase())) 
    			rslt = true;
    	}
    	
    	return rslt;
    }
    
    public static boolean matches(String patterns[], String searchString) {
    	if(searchString == null && patterns == null) return true;
    	if(searchString == null) return false;
    	if(patterns == null) return false;
    	
    	boolean rslt = false;
    	
    	for(int i = 0; ! rslt && i < patterns.length; i++) {
    		rslt = matches(patterns[i], searchString);
    	}
    	
    	return rslt;
    }
    
    public static boolean matches(String pattern, String searchString) {
    	if(pattern == null) return true;
    	if(pattern.trim().length() == 0) return true;
    	if(searchString == null) return false;
    	
    	Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(searchString);
    	
    	return matcher.find();
    }
    
    public static String array2string(String[] array) {
    	if(array == null) return null;
    	
    	StringBuffer buf = new StringBuffer();
    	for(int i = 0; i < array.length; i++) {
    		buf.append((buf.length() == 0 ? "" : ",") + array[i]);
    	}
    	
    	return buf.toString();
    	
    }
    
    /**
     * Removes any non-printing characters
     * @param s
     * @return
     */
    public static String clean(String s) {
    	if(s == null) return null;
    	
    	String rslt = s.replaceAll("\\p{Cntrl}", "");
    	
    	return rslt;
    }
    
}
