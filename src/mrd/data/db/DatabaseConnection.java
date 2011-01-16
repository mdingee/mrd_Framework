package mrd.data.db;

import mrd.data.db.query.Query;
import mrd.data.db.query.QueryFactory;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import mrd.data.Field;
import mrd.data.Record;
import mrd.data.SimpleRecord;
import mrd.data.AggregateRecord;

/**
 * @author  mrdlap
 */
public abstract class DatabaseConnection {

	private String _url;

	private String _username;

	private String _password;

	private Driver _driver;

	private boolean _isDebugMode = true;
	
	Connection _conn;
	
	protected Properties _props;
	
	protected void buildConnection(Driver driver, String url, String username, String password) throws SQLException {
		_driver = driver;
		_url = url;
		
		DriverManager.registerDriver (driver);	
	    _conn = DriverManager.getConnection(url, username , password);	 
	    _conn.setAutoCommit(false);
	}
	
	public boolean isDebugMode() { return _isDebugMode; }
	
	public void setDebugMode() { _isDebugMode = true; }
	
	public void setLiveMode() { _isDebugMode = false; }
	
	public String getUrl() { return _url; }
	
	public String getUsername() { return _username; }

	public String getPassword() { return _password; }
	
	public Driver getDriver() { return _driver; }
	
	public Connection getConnection() { return _conn; }
	
	public abstract String getDatabaseName();
	
	public abstract boolean testConnection();

        public abstract QueryFactory getQueryFactory();
	
	protected void commit() throws SQLException  { getConnection().commit(); }
	
	protected void rollback() { 
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getStatement(String sql, List <Field> conditions) throws SQLException {
		int ctr = 1;
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		
		if(conditions != null) {
			for(Field df : conditions) {
				if(df.getValue() == null)
					ps.setNull(ctr, df.getFieldType());
				else
					ps.setObject(ctr, df.getValue(), df.getFieldType());
				
				ctr++;
			}
		}
		return ps;
	}

	public PreparedStatement getStatement(Query q) throws SQLException {
		return getStatement(q.getQuery(), q.getConditions());
	}

	protected PreparedStatement insert(Record record, PreparedStatement seed) {
		StringBuffer bufFields = new StringBuffer();
		StringBuffer bufValues = new StringBuffer();
		
		PreparedStatement ps = seed;
		Vector <Field> values = new Vector <Field> ();

		Iterator <Field> j = record.getFields().iterator();
		
		while(j.hasNext()) {
			Field df = j.next();
			bufFields.append((bufFields.length() == 0 ? " " : ", ") + df.getFieldName());
			bufValues.append((bufValues.length() == 0 ? " " : ", ") + "?");
			values.add(df);
		}
		
		j = null;
		
		String sql = "INSERT INTO " + record.getTableName() + "(" + bufFields.toString() + ") values (" + bufValues.toString() + ")";

		try {
			if(seed == null)
				ps = getConnection().prepareStatement(sql);
			else
				ps.addBatch(sql);
			
			for(int i = 0; i < values.size(); i++) {
				if(values.get(i).getValue() == null)
					ps.setNull(ps.getParameterMetaData().getParameterCount() + 1, values.get(i).getFieldType());
				else
					ps.setObject(ps.getParameterMetaData().getParameterCount() + 1, values.get(i).getValue(), values.get(i).getFieldType());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return ps;
	}
	
	protected PreparedStatement update(Record record, PreparedStatement seed) {
		Vector <Field> values = new Vector <Field> ();
		PreparedStatement ps = seed;
		String sql;
		Iterator <Field> i = record.getFields().iterator();
		StringBuffer buf = new StringBuffer();
		
		while(i.hasNext()) {
			Field df = i.next();
			buf.append((buf.length() == 0 ? " " : ", ") + df.getFieldName() + " = ? ");
			values.add(df);
		}
		
		Iterator <Field> j = record.getKeyFields().iterator();
		StringBuffer bufWhere = new StringBuffer();
		
		while(j.hasNext()) {
			Field df = j.next();
			bufWhere.append((bufWhere.length() == 0 ? " " : " AND ") + df.getFieldName() + " = ? ");
			values.add(df);
		}
		
		sql = "UPDATE " + record.getTableName() + " SET " + buf.toString() + " WHERE " + bufWhere.toString();
		
		try {
			if(ps == null)
				ps = getConnection().prepareStatement(sql);
			else
				ps.addBatch(sql);
		
			for(int k = 0; k < values.size(); k++) {
				if(values.get(k).getValue() == null)
					ps.setNull(ps.getParameterMetaData().getParameterCount() + 1, values.get(k).getFieldType());
				else
					ps.setObject(ps.getParameterMetaData().getParameterCount() + 1, values.get(k).getValue(), values.get(k).getFieldType());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ps;
		
	}
	
	public Integer executeStatementReturnInteger(PreparedStatement ps) throws SQLException {
		ResultSet rs = null;
		Integer rslt = null;
		
		ps.execute();
		rs = ps.getResultSet();
		
		if(rs.next())
			rslt = rs.getInt(1);
		
		rs.close();
		rs = null;
		
		return rslt;
	}
	
	public Number executeSQLReturnNumber(String sql) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BigDecimal rslt = null;
		
		try {
			ps = _conn.prepareStatement(sql);
			ps.execute();
			
			rs = ps.getResultSet();
			
			if(rs.next())
				rslt = rs.getBigDecimal(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { rs.close(); rs = null; } catch (Exception e) {e.printStackTrace();}
			try { ps.close(); ps = null; } catch (Exception e) {e.printStackTrace();}
		}
		
		
		return rslt;
	}
	
	public void executeStatement(String sql) throws SQLException {
		PreparedStatement ps = null;
		
		try {
			ps = _conn.prepareStatement(sql);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { ps.close(); ps = null; } catch (Exception e) {e.printStackTrace();}
		}
	}
}
