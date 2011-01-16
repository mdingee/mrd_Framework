package mrd.data.db.as400;

import java.util.Properties;

import mrd.data.db.DatabaseConnection;



public abstract class AS400Connection extends DatabaseConnection {
	/**
	 * @uml.property  name="_instance"
	 */
	String _instance;
	
	public AS400Connection() {}
	
	public AS400Connection(Properties properties) throws Exception {
		_instance = properties.getProperty("SID");
		_props = properties;
		setConnection(properties.getProperty("SERVER")
				     ,properties.getProperty("SID")
				     ,properties.getProperty("USERNAME")
				     ,properties.getProperty("PASSWORD")); 
	}

	@Override
	public String getDatabaseName() { return _props.getProperty("SID"); }
	
	protected void setConnection(String server, String instance, String username, String password) throws Exception {
		_instance = instance;
		
		String url = "jdbc:as400://"
			+ _props.getProperty("SERVER") + "/"
			+ _props.getProperty("SID") + ";"		
			+ _props.getProperty("ADDPARAMS");
		
		buildConnection(new com.ibm.as400.access.AS400JDBCDriver(), url, username, password);
	}

	@Override
	public boolean testConnection() {
		return false;
	}

}
	
