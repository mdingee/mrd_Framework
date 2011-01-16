package mrd.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileUtilsTest {
        public FileUtilsTest() { System.out.print(this.getClass().getCanonicalName() + "."); }

	@Test
	public void testDoesFileExist_true() {
                System.out.println("doesFileExist true");
		assertTrue(FileUtils.doesFileExist("C:/TTi/NetbeansProjects/mrd_ApplicationFramework/test.txt"));
	}
	
	@Test
	public void testDoesFileExist_false() {
                System.out.println("doesFileExist false");
		assertFalse(FileUtils.doesFileExist("C:/TTi/NetbeansProjects/mrd_ApplicationFramework/non-existant-file.txt"));
	}

}
