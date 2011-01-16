package mrd.data;

public abstract class AggregateIntegerField extends AggregateField {
	private Integer value;
	
	protected AggregateIntegerField(String fieldName, AggregateType type) {
		super(fieldName, java.sql.Types.INTEGER, type);
	}

        protected AggregateIntegerField(String fieldName, AggregateType aggType, Integer value) {
		this(fieldName, aggType);
		this.value = value;
	}

	@Override
	public Object getValue() { return getIntegerValue(); }
	
	protected void setIntegerValue(Integer value){ setValue(value); }
	
	protected Integer getIntegerValue() { return value; }

	@Override
	public void setValue(Object value) {
		if(value == null) return;
		
		if(value instanceof Number) {
			this.value = ((Number) value).intValue();
			increment();
		}
	}
	
	@Override
	public void add(Object value) {
		if(value == null) return;
		
		if(!(value instanceof Number)) return;
		
		Integer intValue = null;
		
		if(value instanceof Number) {
			Number numValue = (Number) value;
			intValue = numValue.intValue();
		}
		
		if(getIntegerValue() == null)
			setIntegerValue(intValue);
		else
			setIntegerValue(intValue.intValue() + getIntegerValue().intValue());
		
	}

}
