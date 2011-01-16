package mrd.data;

import java.sql.Date;
import mrd.data.AbstractDateField;



public class DateField extends AbstractDateField {
	
	public DateField(String fieldName) {
		super(fieldName);
	}
	
	public DateField(String fieldName, Date value) {
		super(fieldName, value);
	}
	
	public void setDateValue(java.sql.Date value) { super.setDateValue(value); }
	
	public java.sql.Date getDateValue() { return super.getDateValue(); }

	@Override
	public Object clone() {
		DateField rslt = new DateField(getFieldName(), (java.sql.Date) getDateValue().clone());
		rslt.setFieldTitle(getFieldTitle());
		return  rslt;
	}

}
