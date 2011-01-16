package mrd.data.db.oracle;

import java.sql.*;
import java.util.Properties;

import mrd.data.db.DatabaseConnection;
import mrd.data.db.query.QueryFactory;



public class OracleConnection extends DatabaseConnection {
	/**
	 * @uml.property  name="_instance"
	 */
	protected String _instance;
	
	protected OracleConnection() {  }
	
	protected OracleConnection(String instance) { _instance = instance; }
	
	public OracleConnection(Properties properties) throws SQLException {
		_props = (properties == null ? new Properties() : properties);
		
		_instance = _props.getProperty("SID");
		
		String port = (_props.containsKey("PORT") ? _props.getProperty("PORT") : "1521");
		
		setConnection(_props.getProperty("SERVER"), _props.getProperty("SID"), port, _props.getProperty("USERNAME"), _props.getProperty("PASSWORD"));
	}

	protected void setConnection(String server, String instance, String port, String username, String password) throws SQLException {
		_instance = instance;
		
		String url = "jdbc:oracle:thin:@//" + server + ":" + port + "/" + instance;
		
		buildConnection(new oracle.jdbc.driver.OracleDriver(), url, username, password);
	}
	
	@Override
	public String getDatabaseName() { return _instance; }
	
	@Override
	public boolean testConnection() {
		String sql = "select 1 from dual";
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean rslt = false;
		
		try {
			ps = getConnection().prepareStatement(sql);
			ps.execute();
			rs = ps.getResultSet();
			rs.next();
			
			rslt = true;
		} catch (Exception e) { 
			e.printStackTrace();
			rslt = false;
		} finally {
			try { rs.close(); rs = null; } catch (Exception e) { e.printStackTrace(); }
			try { ps.close(); ps = null; } catch (Exception e) { e.printStackTrace(); }
		}
		
		return rslt;
	}

    @Override
    public QueryFactory getQueryFactory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
