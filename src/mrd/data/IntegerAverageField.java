package mrd.data;


public class IntegerAverageField extends AggregateIntegerField {
	
	public IntegerAverageField(String fieldName) {
		super(fieldName, AggregateType.AVERAGE);
	}

        public IntegerAverageField(String fieldName, Integer value) {
		this(fieldName);
		setIntegerValue(value);
	}

	@Override
	public Object getValue() { return getAverage(); } 

        @Override
	public Integer getIntegerValue() { return getAverage(); }
	
	private Integer getAverage() {
		if(super.getIntegerValue() == null) return null;
		if(getCount() == 0) return null;
		
		return super.getIntegerValue().intValue() / getCount();
	}
	
	@Override
	public Object clone() {
                IntegerAverageField field = new IntegerAverageField(this.getFieldName(), this.getIntegerValue());
                field.setFieldAlias(this.getFieldAlias());
                field.setFieldTitle(this.getFieldTitle());
                field.setCount(this.getCount());
		return field;
	}
}
