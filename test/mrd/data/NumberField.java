package mrd.data;

import mrd.data.AbstractNumberField;



public class NumberField extends AbstractNumberField {
	
	public NumberField(String fieldName) {
		super(fieldName);
	} 
	
	public NumberField(String fieldName, Number value) {
		super(fieldName, value);
	}
	
	public void setNumberValue(Number value){ super.setNumberValue(value); }
	
	public Number getNumberValue() { return super.getNumberValue(); }

	@Override
	public Object clone() {
		NumberField rslt = new NumberField(getFieldName(), getNumberValue());
		rslt.setFieldTitle(getFieldTitle());
		return rslt;
	}
}
