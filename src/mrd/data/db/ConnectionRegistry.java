package mrd.data.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;




public class ConnectionRegistry {
	/**
	 * @uml.property  name="_connections"
	 * @uml.associationEnd  qualifier="connName:java.lang.String tti.data.db.DatabaseConnection"
	 */
	private HashMap <String, DatabaseConnection> _connections = new HashMap <String,DatabaseConnection> (); 
	private static boolean _isDebugMode = false;
	
	private ConnectionRegistry() {}
	
	public static void registerConnection(String connName, DatabaseConnection dbconn) {
		if(! getInstance()._connections.containsKey(connName)) {
			if(_isDebugMode) dbconn.setDebugMode();
			else dbconn.setLiveMode();
			
			try { dbconn.getConnection().setAutoCommit(true); }
			catch (SQLException e) { e.printStackTrace(); }
			getInstance()._connections.put(connName, dbconn);
		}
	}
	
	public static DatabaseConnection getConnection(String connName) {
		if(getInstance()._connections.containsKey(connName))
			return getInstance()._connections.get(connName);
		else
			return null;
	}
	
	public static void printAllRegistrations() {
		System.out.println("Printing registered connections...");
		Iterator<String> i = getInstance()._connections.keySet().iterator();
		while(i.hasNext()) {
			String name = i.next();
			System.out.println("   " + name + " " + (testConnection(name) ? "OK" : "CONNECTION CLOSED"));
		}
	}
	
	public static boolean testConnection(String connName) {
		return getConnection(connName).testConnection();
	}
	
	public static void setDebugMode() {
		_isDebugMode = true;
		
		Iterator <String> i = getInstance()._connections.keySet().iterator();
		while(i.hasNext()) {
			String key = i.next();
			getConnection(key).setDebugMode();
		}
	}
	
	public static void setLiveMode() {
		_isDebugMode = false;
		
		Iterator <String> i = getInstance()._connections.keySet().iterator();
		while(i.hasNext()) {
			String key = i.next();
			getConnection(key).setLiveMode();
		}
	}
	
	public static ConnectionRegistry getInstance() { return SingletonHolder.INSTANCE; }
	
	/**
	 * @author  mrdlap
	 */
	private static class SingletonHolder {
		/**
		 * @uml.property  name="iNSTANCE"
		 * @uml.associationEnd  
		 */
		public static final ConnectionRegistry INSTANCE = new ConnectionRegistry();
	}
}
