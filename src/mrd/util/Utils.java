package mrd.util;

public class Utils {

	public static String nvl(String s1, String s2) {
		if(s1 == null || s1.trim().length() == 0) return s2;
		return s1;
	}

	public static Number nvl(Number n1, Number n2) {
		if(n1 == null) return n2;
		return n1;
	}

}
