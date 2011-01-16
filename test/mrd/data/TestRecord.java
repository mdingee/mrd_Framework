package mrd.data;

public class TestRecord extends Record{

	/**
	 * @uml.property  name="stringField"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	StringField  stringField  = new StringField("FIELD1");
	/**
	 * @uml.property  name="numberField"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	NumberField  numberField  = new NumberField("FIELD2");
	/**
	 * @uml.property  name="integerField"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	IntegerField integerField = new IntegerField("FIELD3");
	/**
	 * @uml.property  name="dateField"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	DateField    dateField    = new DateField("FIELD4");
	
	public TestRecord(String tableName) {
		super(tableName);
		addFieldsByReflection();
	}
	
	public TestRecord(String tableName, String field1, Number field2, Integer field3, java.sql.Date field4) {
		this(tableName);
		setString(field1);
		setNumber(field2);
		setInteger(field3);
		setDate(field4);
	}
	
	public void setString(String value) { stringField.setStringValue(value); }
	public void setNumber(Number value) { numberField.setNumberValue(value); }
	public void setInteger(Integer value) { integerField.setIntegerValue(value); }
	public void setDate(java.sql.Date value) { dateField.setDateValue(value); }
	
	public String  getString(String value) { return stringField.getStringValue(); }
	public Number  getNumber(Number value) { return numberField.getNumberValue(); }
	public Integer getInteger(Integer value) { return integerField.getIntegerValue(); }
	public java.sql.Date getDate(java.sql.Date value) { return dateField.getDateValue(); }

}
