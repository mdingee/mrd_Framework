package mrd.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mrd.data.Field;
import mrd.data.Record;
import mrd.data.SimpleField;

public abstract class AggregateRecord extends Record {

	public AggregateRecord(String tableName) {
		super(tableName);
	}
	
	public List <AggregateField> getAggregateFields() {
		List <Field> fields = getFields();
		
		if(fields == null) return null;
		
		List <AggregateField> rslt = new ArrayList <AggregateField>();
		
		for(Field each : fields) {
			if(each instanceof AggregateField)
				rslt.add((AggregateField) each);
		}
			
			
		return rslt; 
	}
	
	public List <SimpleField> getSimpleFields() {
		List <Field> fields = getFields();
		
		if(fields == null) return null;
		
		List <SimpleField> rslt = new ArrayList <SimpleField>();
		
		for(Field each : fields) {
			if(each instanceof SimpleField)
				rslt.add((SimpleField) each);
		}
			
			
		return rslt; 
	}
	
	public void add(Record record) {
		if(record == null) return;
		
		Collection <AggregateField> aggFields = getAggregateFields();
		
		for(AggregateField each : aggFields)
			each.add(record.getValue(each.getFieldName()));
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		Collection <Field> fields = getFields();
		if(fields == null) return result;
		
		for(Field each : fields)
			result = prime * result + (each == null ? 0 : each.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		AggregateRecord other = (AggregateRecord) obj;
		
		List <SimpleField> thisFields = this.getSimpleFields();
		List <SimpleField> otherFields = other.getSimpleFields();
		
		if(thisFields == null && otherFields != null) return false;
		if(thisFields != null && otherFields == null) return false;
		
		return thisFields.equals(otherFields);
	}
	
	
	
}
