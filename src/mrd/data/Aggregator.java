package mrd.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import mrd.data.Field;
import mrd.data.Record;
import mrd.data.SimpleField;


public class Aggregator {
	/**
	 * @uml.property  name="map"
	 * @uml.associationEnd  qualifier="getGroupFields:java.util.Vector tti.data.agg.AggregateRecord"
	 */
	private HashMap <List <SimpleField>, AggregateRecord> map;
	/**
	 * @uml.property  name="factory"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private AggregateRecordFactory factory;
	
	public Aggregator(AggregateRecordFactory factory) {
		map = new HashMap<List <SimpleField>, AggregateRecord>();
		this.factory = factory;
	}
	
	public int getCount() { return map.size(); }
	
	public Collection<AggregateRecord> getRecords() {
		Collection <AggregateRecord> rslt = new ArrayList<AggregateRecord>();
		rslt.addAll(map.values());
		return rslt;
	}
	
	public void add(Record record) {
		if(record == null) return;
		
		AggregateRecord agg = factory.build(record);
		
		replace(agg);
	}
	
	private void replace(AggregateRecord newRecord) {
		if(newRecord == null) return;
		
		if(map.containsKey(newRecord.getSimpleFields())) {
			AggregateRecord oldRecord = map.remove(newRecord.getSimpleFields());
			newRecord.add(oldRecord);
		}
		
		map.put(newRecord.getSimpleFields(), newRecord);
		
	}
}
