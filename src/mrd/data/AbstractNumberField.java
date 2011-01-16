package mrd.data;

public abstract class AbstractNumberField extends SimpleField {
	private Number value;
	
	protected AbstractNumberField(String fieldName, Number value) {
		this(fieldName);
		setNumberValue(value);
	}

	protected AbstractNumberField(String fieldName) {
		super(fieldName, java.sql.Types.NUMERIC);
	}

	protected void setNumberValue(Number value) { setValue(value); }

	protected Number getNumberValue() { return (Number) getValue(); }
	
	public void setValue(Object value) {
		if(value == null || value instanceof Number)
			this.value = (Number) value;
	}
	
	public Object getValue() { return this.value; }
	
}