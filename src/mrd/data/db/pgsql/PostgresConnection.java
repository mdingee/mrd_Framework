package mrd.data.db.pgsql;

import java.sql.*;
import java.util.Properties;
import mrd.data.SimpleRecord;
import mrd.data.AggregateRecord;
import mrd.data.db.filter.AbstractFilter;
import mrd.data.db.query.AggregateRecordQuery;

import mrd.data.db.DatabaseConnection;
import mrd.data.db.query.QueryFactory;
import mrd.data.db.query.SimpleRecordQuery;

public class PostgresConnection extends DatabaseConnection {
	
	private String _instance;
	private PostgresQueryFactory queryFactory = new PostgresQueryFactory(this);

	public PostgresConnection(Properties properties) throws SQLException {
		_props = (properties == null ? new Properties() : properties);
		_instance = _props.getProperty("SID");
		//printAllProperties();
		setConnection(_props.getProperty("SERVER"), _props.getProperty("SID"), _props.getProperty("USERNAME"), _props.getProperty("PASSWORD"));
		
	}

	protected void setConnection(String server, String instance, String username, String password) throws SQLException {
		_instance = instance;
		
		String url = "jdbc:postgresql://" + server + ":5432/" + instance;
		
		buildConnection(new org.postgresql.Driver(), url, username, password);
		
	}
	
	@Override
	public boolean testConnection() {
		String sql = "select 1";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();
			rs.close();
			ps.close();
			return true;
		} catch (Exception e) { return false;}
	}
	
	@Override
	public String getDatabaseName() { return _instance; }

    @Override
    public QueryFactory getQueryFactory() { return queryFactory; }
	
}
