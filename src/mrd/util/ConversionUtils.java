package mrd.util;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class ConversionUtils {
	
	public static void printProperties(Properties _props) {
		//System.out.println("Printing properties...");
		if(_props != null) {
			Set <String> s = _props.stringPropertyNames();
			Iterator <String> i = s.iterator();
			while(i.hasNext()) {
				String key = i.next().toString();
				System.out.println("   " + key + " = " + _props.getProperty(key) );
			}
		}
	}
}
