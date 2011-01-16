package mrd.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class AggregateStringField extends AggregateField {
	
	private char seperator = '|';

        private Set <String> values = new HashSet <String> ();
	
	public AggregateStringField(String fieldName) {
		super(fieldName, java.sql.Types.VARCHAR, AggregateType.STRING_AGGREGATE);
	}
	
	public AggregateStringField(String fieldName, char seperator) {
		this(fieldName);
		this.seperator = seperator;
	}
	
	protected String getStringValue() { 
            if(values.isEmpty()) return null;

            String rslt = null;

            Iterator <String> i = values.iterator();

            while(i.hasNext()) {
                String temp = i.next();
                rslt = (rslt == null ? "" : rslt + seperator) + temp;
            }

            return rslt;
        }

        protected void setStringValue(String value, char seperator) {
            if(value == null) {
                values = new HashSet <String> ();
                return;
            }

            String[] list = value.split("" + seperator);

            for(String each : list)
                add(each);
        }

        protected char getSeperator() { return seperator; }

	@Override
	public void add(Object value) {
		if(value == null) return;
		
		String string = (String) value;

                if(! values.contains(string))
                    values.add(string);
	}
	
	@Override
	public Object getValue() { return getStringValue(); }
	
	@Override
	public void setValue(Object value) { 
            if(value == null) {
                values = new HashSet <String> ();
                return;
            }
            
            if(!(value instanceof String)) return;
            
           setStringValue((String) value, this.seperator);
        }
	
	@Override
	public Object clone() {
            AggregateStringField field = new AggregateStringField(getFieldName(), getSeperator());
            field.setCount(getCount());
            field.setStringValue(getStringValue(), getSeperator());
            field.setFieldAlias(getFieldAlias());
            field.setFieldTitle(getFieldTitle());
            return field;

	}
}
