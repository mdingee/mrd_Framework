package mrd.data.db;

import java.util.Iterator;
import java.util.Properties;

import mrd.Application;
import mrd.util.ConversionUtils;

public abstract class DatabaseApplication extends Application {
	/**
	 * @uml.property  name="defaultConnection"
	 */
	private String defaultConnection = null;
	
	public DatabaseConnection getDefaultConnection() {
		return getConnection(defaultConnection);
	}

	/**
	 * @param defaultConnection
	 * @uml.property  name="defaultConnection"
	 */
	protected void setDefaultConnection(String defaultConnection) {
		this.defaultConnection = defaultConnection;
	}

	public DatabaseApplication(String configurationFile) {
		super(configurationFile);
	}

	@Override
	protected void finish() throws Exception { }

	@Override
	protected void init(Properties props) throws Exception {
		setupConnections(props);
	}

	@Override
	protected void runApplication() throws Exception { }
	
	/**
	 * Iterate through all loaded property files listed in _props and create connections
	 */
	private void setupConnections(Properties props) {
		Iterator <Object> i = props.keySet().iterator();
		while(i.hasNext()) {
			String temp = i.next().toString();
			if(temp.startsWith("DBCONN_")) {
				String key = temp.replace("DBCONN_", "");
				ConnectionRegistry.registerConnection(key,setupConnection(getPropertiesFromFile(key)));
			}
			
		}
	}
	
	private DatabaseConnection setupConnection(Properties properties) {
		//System.out.println("Setting up a database connection");
		try {
			ConversionUtils.printProperties(properties);
			return DatabaseConnectionFactory.createDatabaseConnection(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public DatabaseConnection getConnection(String connName) {
		return ConnectionRegistry.getConnection(connName);
	}

}
