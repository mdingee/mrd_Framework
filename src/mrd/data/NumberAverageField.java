package mrd.data;

public class NumberAverageField extends AggregateNumberField {
	
	public NumberAverageField(String fieldName) {
		super(fieldName, AggregateType.AVERAGE);
	}

         public NumberAverageField(String fieldName, Number value) {
		this(fieldName);
                setNumberValue(value);
	}
	
	@Override
	public Object getValue() { return getAverage(); }

        @Override
	public Number getNumberValue() { return getAverage(); }
	
	private Number getAverage() {
		Number value = super.getNumberValue();
		
		if(value == null) return null;
		if(getCount() == 0) return null;
		
		return value.doubleValue() / getCount(); 
	}
	
	@Override
	public Object clone() {
            NumberAverageField field = new NumberAverageField(getFieldName(), getNumberValue());
            field.setCount(getCount());
            field.setFieldAlias(getFieldAlias());
            field.setFieldTitle(getFieldTitle());
            return field;
	}
}
