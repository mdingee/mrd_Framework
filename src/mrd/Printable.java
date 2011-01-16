package mrd;

import java.util.*;

import mrd.util.StringUtils;

/**
 * @author  mrdlap
 */
public abstract class Printable {
	/**
	 * @uml.property  name="_notes"
	 */
	protected String _notes = "";
	
	/**
	 * @uml.property  name="name"
	 */
	public abstract String getName();
	
	public abstract List <String> getFields();
	
	public abstract List <Object> getValues();
	
	public void addNote(String note) {
		if(_notes.equals("")) _notes = note;
		else _notes += "," + note;
	}
	
	public String getNotes() { return _notes; }
	
	public String getHeader() {
		if(getFields() == null) return null;
		
		StringBuffer buf = new StringBuffer();
		buf.append("");
		Iterator <String> f = getFields().iterator();
		while(f.hasNext()) {
			buf.append((buf.toString().equals("") ? "" : ",") + "\"" + f.next() + "\"");
		}
		
		return StringUtils.clean(buf.toString());
	}
	
	public String getData() {
		if(getValues() == null) return null;
		
		StringBuffer buf = new StringBuffer();
		
		Iterator <Object> f = getValues().iterator();
		while(f.hasNext()) {
			Object o = f.next();
			buf.append((buf.length() == 0  ? "" : ",") + (o == null || o.toString().trim().equals("null") ? "\"\"" : "\"" + o.toString() + "\""));
		}
		
		return StringUtils.clean(buf.toString());
	}
}
