package mrd.data;



public class IntegerField extends AbstractIntegerField {
	
	public IntegerField(String fieldName) {
		super(fieldName);
	} 
	
	public IntegerField(String fieldName, Integer value) {
		super(fieldName, value);
	}
	
    @Override
	public Integer getIntegerValue() { return super.getIntegerValue(); }
	
    @Override
	public void setIntegerValue(Integer value) { super.setIntegerValue(value); }

	@Override
	public Object clone() {
		IntegerField rslt = new IntegerField(getFieldName(), getIntegerValue());
		rslt.setFieldTitle(getFieldTitle());
		return  rslt;
	}
	
	
}
