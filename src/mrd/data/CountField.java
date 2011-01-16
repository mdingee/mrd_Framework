package mrd.data;

public class CountField extends IntegerSumField {

	public CountField(String fieldName) {
		super(fieldName);
	}

	@Override
	public void add(Object value) {
		if(value == null) return;
		setValue(getCount());
	}
	
	public Integer getIntegerValue() { return getCount(); }
	
	public Object getValue() { return getIntegerValue(); }

}
