package mrd;

import java.io.*;
import java.util.Collection;
import java.util.Properties;

import java.util.Iterator;

import mrd.util.DateUtils;
import mrd.util.FileUtils;

public abstract class Application {
	//protected HashMap <String, DatabaseConnection> _connections = new HashMap<String, DatabaseConnection>();
	//protected Properties _props = new Properties();
	public static final String _configDirectory = "c:/jars/config/"; // "./config/";
	
	/**
	 * @uml.property  name="isErrorFileOutput"
	 */
	private boolean isErrorFileOutput = false;
	/**
	 * @uml.property  name="isOutputFileOutput"
	 */
	private boolean isOutputFileOutput = false;
	
	/**
	 * @uml.property  name="oput"
	 */
	BufferedOutputStream oput;
	/**
	 * @uml.property  name="err"
	 */
	BufferedOutputStream err;
	
	private static String ts = DateUtils.ts();
	
	public Application(String configurationFile) {
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutDownListener()));
        Properties props = getPropertiesFromFile(configurationFile);
        
        try { init(props); }
		catch (Exception e) { e.printStackTrace(); }
        
		if(isErrorFileOutput) {
			try { 
				err  = new BufferedOutputStream(new FileOutputStream(ApplicationRegistry.getOutputDirectory() + configurationFile + "." + DateUtils.ts() + ".err.txt"));
				System.setErr(new PrintStream(err));
			} catch (FileNotFoundException e1) {e1.printStackTrace();} 
		}
		
		if(isOutputFileOutput) {
			try { 
				oput = new BufferedOutputStream(new FileOutputStream(ApplicationRegistry.getOutputDirectory() + configurationFile + "." + DateUtils.ts() + ".txt"));
				System.setOut(new PrintStream(oput)); 
			} catch (FileNotFoundException e1) {e1.printStackTrace();} 
		}

		try { 
			runApplication();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try { 
			finish();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void print(Printable p) { 
		print(p, ApplicationRegistry.getOutputDirectory() + p.getName() + "." + ts + ".csv");
	}
	
	public void print(Printable p, String file) { 
		PrintStream ps = null;
		boolean state = FileUtils.doesFileExist(file);
		
		try { ps = new PrintStream(new FileOutputStream(file, true)); }
		catch (Exception e) { e.printStackTrace(); ps = System.err; }
		
		if(! state) {
			ps.print(p.getHeader() + ",\"Notes\"\r\n");
		}
		 
		ps.print(p.getData() );
		ps.print(",\"" + p.getNotes() + "\"\r\n"); 
		
		ps.flush();
		ps.close();
}
	
	/**
	 * 
	 * @param e
	 * @return The full path and filename where the Exportable was printed
	 */
	public String print(Exportable e) {
		if(e == null) return null;
		
		Collection <Printable> c = e.getPrintables();
		
		if (c == null) return null;
		String path = null;
		
		Iterator <Printable> i = c.iterator();
		
		while(i.hasNext()) {
			Printable p = i.next();
			if(path == null) path = ApplicationRegistry.getOutputDirectory() + p.getName() + "." + DateUtils.ts() + ".csv";
			print(p, path);
		}
		
		return path;
	}
	
	protected abstract void runApplication() throws Exception;
	
	protected abstract void init(Properties props) throws Exception ;
	
	protected abstract void finish() throws Exception;
	
	protected void sendOutputToConsole() { isOutputFileOutput = false; }
	
	protected void sendErrorToConsole() { isErrorFileOutput = false; }
	
	protected void sendOutputToFile() { isOutputFileOutput = true; }
	
	protected void sendErrorToFile() { isErrorFileOutput = true; }
	
	protected Properties getPropertiesFromFile(String fileName) {
		String t_fileName = _configDirectory + fileName + ".properties";
		FileInputStream io = null;
		Properties props = new Properties();
		
		System.out.println("PropertyFile: " + t_fileName);
		
		try {
			io = new FileInputStream(t_fileName);
			props.load(io);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { io.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
		return props;
	}
	
	class ShutDownListener implements Runnable {
	    @Override
	    public void run()   {
	    	try { 
	    		if(oput != null)
	    			oput.flush();
	    		if(err != null)
	    			err.flush(); 
	    	} catch (Exception e) { 
	    		e.printStackTrace(); 
	    	}
	    }
	}
}
