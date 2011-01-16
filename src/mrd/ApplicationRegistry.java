package mrd;


public class ApplicationRegistry {
	
	//private boolean _isDebugMode = true;
	
	//private HashMap <String, ConversionRecord> _cvTables = new HashMap <String, ConversionRecord> ();
	//private HashMap <String, TranslationMap> _cvMaps = new HashMap <String, TranslationMap> ();
	/**
	 * @uml.property  name="_outputDirectory"
	 */
	private String _outputDirectory;
	/**
	 * @uml.property  name="_email"
	 */
	private String _email;
	
	private ApplicationRegistry() {}
	
	public static void setEmailAddress(String emailAddress) { getInstance()._email = emailAddress; }
	
	public static String getEmailAddress() { return getInstance()._email; }
	/*
	public static void registerConversionTable(String tableName) {
		if(! getInstance()._cvTables.containsKey(tableName)) 
			getInstance()._cvTables.put(tableName, new ConversionRecord(tableName));
	}
	
	public static void recordRead(String tableName) {
		if(getInstance()._cvTables.containsKey(tableName))
			getInstance()._cvTables.get(tableName).recordRead();
		else {
			registerConversionTable(tableName);
			recordRead(tableName);
		}
			
	}
	
	public static void recordWrite(String tableName) {
		if(getInstance()._cvTables.containsKey(tableName))
			getInstance()._cvTables.get(tableName).recordWrite();
		else {
			registerConversionTable(tableName);
			recordWrite(tableName);
		}
	}
	
	public static void recordError(String tableName) {
		if(getInstance()._cvTables.containsKey(tableName))
			getInstance()._cvTables.get(tableName).recordError();
		else {
			registerConversionTable(tableName);
			recordError(tableName);
		}
	}
	
	public static void registerMapTable(TranslationMap map) {
		if(! getInstance()._cvMaps.containsKey(map.getName()))
			getInstance()._cvMaps.put(map.getName(), map);
	}
	
	public static HashMap<String, TranslationMap> getMaps() {
		return getInstance()._cvMaps;
	}
	
	public static HashMap <String, ConversionRecord> getConversionTables() { 
		return getInstance()._cvTables; 
	}
	*/
	public static ApplicationRegistry getInstance() { return SingletonHolder.INSTANCE; }
	/*
	public static void setLiveMode() { 
		getInstance()._isDebugMode = false;
		ConnectionRegistry.setLiveMode();
	}
	
	public static void setDebugMode() { 
		getInstance()._isDebugMode = true;
		ConnectionRegistry.setDebugMode();
	}
	
	public static boolean isDebugMode() {
		return getInstance()._isDebugMode;
	}
	
	public static void printTableResults() {
		int maxSize = getMaxTableNameSize();
		
    	System.out.println("");
    	System.out.println(StringUtils.padRight("TABLE NAME",maxSize) + " RECORDS READ RECORDS WRITTEN ERRORS RECORDED");
    	System.out.println(StringUtils.repeat("-", maxSize) + " ------------ --------------- ---------------");
    	
    	HashMap <String, ConversionRecord> map = getConversionTables();
    	Iterator <String> i = map.keySet().iterator();
    	
    	
    	while(i.hasNext()) {
    		String key = i.next();
    		ConversionRecord t = map.get(key);
    		String rec = StringUtils.padRight(t.getTableName(), maxSize);
    		rec += " ";
    		rec += StringUtils.padLeft("" + NumberFormat.getInstance().format(t.getReadCount()), 12);
    		rec += " ";
    		rec += StringUtils.padLeft("" + NumberFormat.getInstance().format(t.getWrittenCount()), 15);
    		rec += " ";
    		rec += StringUtils.padLeft("" + NumberFormat.getInstance().format(t.getErrorCount()), 15);
    		System.out.println(rec);
    	}
    }
	
	private static int getMaxTableNameSize() {
		int max = 5;
		
		Iterator <String> i = getInstance()._cvTables.keySet().iterator();
		while(i.hasNext()) {
			int curSize = i.next().length();
			if(curSize > max) max = curSize;
		}
		
		return max + 1;
	}
	
	public static void printMapResults() {
    	Iterator <TranslationMap> i = getMaps().values().iterator();
    	while(i.hasNext()) {
    		i.next().printResults();
    	}
    	i = null;
    }
	*/
	public static void setOutputDirectory(String directory) { getInstance()._outputDirectory = directory; 	}
	
	public static String getOutputDirectory() { return getInstance()._outputDirectory; }
	
	/**
	 * @author  mrdlap
	 */
	private static class SingletonHolder {
		/**
		 * @uml.property  name="iNSTANCE"
		 * @uml.associationEnd  
		 */
		public static final ApplicationRegistry INSTANCE = new ApplicationRegistry();
	}
	
	
}
