package mrd.data;

public abstract class AbstractIntegerField extends SimpleField {
	private Integer value;
	
	protected AbstractIntegerField(String fieldName) {
		super(fieldName, java.sql.Types.INTEGER);
	}

	protected AbstractIntegerField(String fieldName, Integer value) {
		this(fieldName);
		setIntegerValue(value);
	}

	protected void setIntegerValue(Integer value) {  setValue(value); }

	protected Integer getIntegerValue() { return (Integer) getValue(); }
	
	public void setValue(Object value) {
		if(value == null || value instanceof Integer)
			this.value = (Integer) value;
	}
	
	public Object getValue() { return this.value; }

}