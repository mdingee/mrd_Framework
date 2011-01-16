package mrd.data;

public abstract class AbstractStringField extends SimpleField implements Cloneable {
	private String value;
	
	public AbstractStringField(String fieldName) {
		super(fieldName, java.sql.Types.VARCHAR);
	}

	public AbstractStringField(String fieldName, String value) {
		this(fieldName);
		setStringValue(value);
	}

	protected void setStringValue(String value) { setValue(value); }

	protected String getStringValue() { return (String) getValue(); }
	
	public void setValue(Object value) {
		if(value == null)
			this.value = null;
		else if(value instanceof String)
			this.value = (String) value;
		else 
			this.value = value.toString();
	}
	
	public Object getValue() { return this.value; }
}