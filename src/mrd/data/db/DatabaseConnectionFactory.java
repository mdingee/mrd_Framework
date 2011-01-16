package mrd.data.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.util.Properties;



public class DatabaseConnectionFactory {
	
	@SuppressWarnings("unchecked")
	public static DatabaseConnection createDatabaseConnection(Properties properties) throws Exception {

		// Instantiate DatabaseConnection
		Class cls = Class.forName(properties.getProperty("TYPE"));
		Class partypes[] = new Class[1];
		partypes[0] = Properties.class;
			
		Constructor ct = cls.getConstructor(partypes);
		Object arglist[] = new Object[1];
		arglist[0] = properties;
			
		return (DatabaseConnection) ct.newInstance(arglist);
	}
	
	public static DatabaseConnection createDatabaseConnection(String propertyFile) throws Exception {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(propertyFile));
			return createDatabaseConnection(props);
		} catch (FileNotFoundException e) {
			System.out.println("Problem reading property file: " + propertyFile);
			e.printStackTrace();
			throw new Exception();
		}
	}
	
}
