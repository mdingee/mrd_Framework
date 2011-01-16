package mrd.data;

import java.util.ArrayList;
import java.util.List;
import mrd.Printable;

public class RecordPrintable extends Printable {
	/**
	 * @uml.property  name="_p"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Record _p;
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	
	public RecordPrintable(Record p, String title) {
		name = title;
		_p = p;
	}
	
	public RecordPrintable(Record p) {
		if(p != null) {
			name = p.getTableName();
			_p = p;
		}
	}

	@Override
	public List<String> getFields() {
		if(_p == null) return null;
		
		List<String> v = new ArrayList<String>();
		
		List <Field> dv = _p.getFields();
		
		for(int i = 0; i < dv.size(); i++)
			if(dv.get(i).getFieldTitle() != null)
				v.add(dv.get(i).getFieldTitle());
			else
				v.add(dv.get(i).getFieldName());
		
		return v;
	}

	@Override
	public List<Object> getValues() {
		if(_p == null) return null;
		
		List<Object> v = new ArrayList<Object>();
		
		List <Field> dv = _p.getFields();
		
		for(int i = 0; i < dv.size(); i++)
			v.add(dv.get(i).getValue());
		
		return v;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	@Override
	public String getName() {
		return name;
	}

}
