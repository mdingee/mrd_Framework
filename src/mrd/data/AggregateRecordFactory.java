package mrd.data;

import java.util.List;



public abstract class AggregateRecordFactory {

	public abstract AggregateRecord build(Record record);


	protected AggregateRecord setValues(AggregateRecord rslt, Record record) {
		if(rslt == null) return null;
		if(record == null) return null;
		
		List <Field> fields = record.getFields();
		
		for(int i = 0; i < fields.size(); i++)
			rslt.setValue(fields.get(i).getFieldName(), fields.get(i).getValue());
		
		return rslt;
	}
}
