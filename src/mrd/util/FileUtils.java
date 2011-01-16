package mrd.util;

import java.io.File;

public class FileUtils {
	public static boolean doesFileExist(String file) {
		try { 
				File f = new File(file); 
				return f.exists();
		}
		catch (Exception e) { 
			return false; 
		}	
	}
}
