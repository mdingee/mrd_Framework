package mrd.data;

import java.sql.Date;

import mrd.util.DateUtils;

public abstract class AbstractDateField extends SimpleField {
	private java.sql.Date value;
	
	protected AbstractDateField(String fieldName, Date value) {
		this(fieldName);
		setDateValue(value);
	}
	
	protected AbstractDateField(String fieldName) {
		super(fieldName, java.sql.Types.DATE);
	}

	protected void setDateValue(java.sql.Date value) { setValue(value); }
	
	protected void setDateValue(java.sql.Timestamp value) {
		if(value == null) setValue(value);
		else setValue(new Date(value.getTime()));
	}

	@Override
	public Object getValue() { return value; }
	
	protected java.sql.Date getDateValue() { return (java.sql.Date) getValue(); }

	public void setValue(Object value) {
		if(value == null || value instanceof java.sql.Date)
			this.value = (java.sql.Date) value;
		
		if(value instanceof java.sql.Timestamp)
			this.value = DateUtils.toDate((java.sql.Timestamp) value);
			
	}
	
}