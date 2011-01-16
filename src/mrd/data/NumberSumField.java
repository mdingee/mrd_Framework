package mrd.data;

public class NumberSumField extends AggregateNumberField {
	
	public NumberSumField(String fieldName) {
		super(fieldName, AggregateType.SUM);
	}
	
	public NumberSumField(String fieldName, Number value) {
		this(fieldName);
		setNumberValue(value);
	}

        
	
	@Override
	public Object clone() { 
            NumberSumField field = new NumberSumField(getFieldName(), getNumberValue());
            field.setCount(getCount());
            field.setFieldAlias(getFieldAlias());
            field.setFieldTitle(getFieldTitle());
            return field;
	}
}
