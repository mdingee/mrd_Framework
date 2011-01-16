package mrd.data;

import mrd.data.AbstractStringField;

public class StringField extends AbstractStringField {

	public StringField(String fieldName) {
		super(fieldName);
	}
	
	public StringField(String fieldName, String value) {
		super(fieldName, value);
	}
	
	public void setStringValue(String value) { super.setStringValue(value); }
	
	public String getStringValue() { return super.getStringValue(); }

	@Override
	public Object clone() {
		StringField rslt = new StringField(getFieldName(), getStringValue());
		rslt.setFieldTitle(getFieldTitle());
		return rslt; 
	}
	
}
