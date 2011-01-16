package mrd.data;

public abstract class AggregateNumberField extends AggregateField {
	private Number value;
	
	protected AggregateNumberField(String fieldName, AggregateType aggregateType) {
		super(fieldName, java.sql.Types.NUMERIC, aggregateType);
	}

        protected AggregateNumberField(String fieldName, AggregateType aggregateType, Number value) {
		this(fieldName, aggregateType);
		this.value = value;
	}

	@Override
	public Object getValue() { return getNumberValue(); }
	
	protected void setNumberValue(Number value){ add(value); }
	
	protected Number getNumberValue() { return value; }

	@Override
	public void setValue(Object value) { add(value); }

        @Override
	public void add(Object value) {
		if(value == null) return;
		if(!(value instanceof Number)) return;

		Number numValue = (Number) value;

		if(getNumberValue() == null)
			this.value = numValue;
		else
			this.value = numValue.doubleValue() + getNumberValue().doubleValue();

		increment();

	}

}
