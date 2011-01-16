package mrd.data;

public class IntegerSumField extends AggregateIntegerField {
	
	public IntegerSumField(String fieldName) {
		super(fieldName, AggregateType.SUM);
	}

        public IntegerSumField(String fieldName, Integer value) {
		this(fieldName);
		setIntegerValue(value);
	}
	
	@Override
	public Object clone() {
            IntegerSumField field = new IntegerSumField(this.getFieldName(), this.getIntegerValue());
            field.setCount(this.getCount());
            field.setFieldAlias(this.getFieldAlias());
            field.setFieldTitle(this.getFieldTitle());
            return field;
	}
}
