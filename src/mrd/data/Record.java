package mrd.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;



public abstract class Record  {

	private String tableName;
	private List <String> keyFields;
	private HashMap <String, Field> fields;
	private List <String> fieldOrder;
	
	protected Record(String tableName) {
		this.tableName = tableName;
		this.fields = new HashMap <String, Field> ();
		this.keyFields = new ArrayList <String> ();
		this.fieldOrder = new ArrayList <String> ();
		
	}
	
	public List <Field> getFields() {
		List <Field> result = new ArrayList <Field>();
		
		for(int i = 0; i < fieldOrder.size(); i++) {
			result.add(fields.get(fieldOrder.get(i)));
		}
		
		return result; 
	}
	
	public String getColumns() {
		StringBuilder buf = new StringBuilder("");
		
		for(int i = 0; i < fieldOrder.size(); i++) {
			Field f = fields.get(fieldOrder.get(i));
			buf.append((buf.length() == 0 ? "" : ","));
                        buf.append(f.getFieldName());
		}
		
		return buf.toString();
	}
	
	public Collection <Field> getKeyFields() {
		Collection <Field> result = new ArrayList <Field>();
		
		for(int i = 0; i < fieldOrder.size(); i++) {
			if(keyFields.contains(fieldOrder.get(i)))
				result.add(fields.get(fieldOrder.get(i)));
		}
		
		return result; 
	}
	
	public String getTableName() { return tableName; }

	//@Override
	public void addField(Field field) {
		if(field != null 
				&& field.getFieldName() != null 
				&& ! fields.containsKey(field.getFieldName())
				&& ! keyFields.contains(field.getFieldName())) {
			
			fields.put(field.getFieldName(), field);
			fieldOrder.add(field.getFieldName());
		}
	}

	public void removeField(String fieldName) {
		if(fieldName != null && fields.containsKey(fieldName)) {
			fields.remove(fieldName);
			fieldOrder.remove(fieldName);
		}
	}

	public void removeField(Field field) {
		removeField(field.getFieldName());
	}

	public void setValue(String fieldName, Object value) {
		if(fields.containsKey(fieldName))
			fields.get(fieldName).setValue(value);
	}

        @Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		
		for(int i = 0; i < fieldOrder.size(); i++) {
			Field f = fields.get(fieldOrder.get(i));
			buf.append((buf.length() == 0 ? "" : ", "));
                        buf.append("[");
                        buf.append(f.getFieldName());
                        buf.append(" = ");
                        buf.append(f.getValue());
                        buf.append("]");
		}
		
		return "Record: " + this.getTableName() + "{" + buf.toString() + "}";
	}
	
	public void setValues(ResultSet rs) {
		String key;
		Iterator <String> i = fields.keySet().iterator();
		while(i.hasNext()) {
			key = i.next();
			try { setValue(key, rs.getObject(key)); } 
			catch (Exception e) {e.printStackTrace();}
			key = null;
		}
		
		i = null;
			
	}
	
	public void setValues(Record record) {
		String key;
		Iterator <String> i = fields.keySet().iterator();
		while(i.hasNext()) {
			key = i.next();
			try { setValue(key, record.getValue(key)); } 
			catch (Exception e) {e.printStackTrace();}
			key = null;
		}
		
		i = null;
	}
	
	public Object getValue(String fieldName) {
		if(fields.containsKey(fieldName))
			return fields.get(fieldName).getValue();
		
		return null;
	}
	
	public boolean hasField(String fieldName) { return fields.containsKey(fieldName); }
	
	@SuppressWarnings("unchecked")
	protected void addFieldsByReflection() {
		try {
			Class cls = this.getClass();
			do {
            
				java.lang.reflect.Field fieldlist[] = cls.getDeclaredFields();
            

				for (int i = 0; i < fieldlist.length; i++) {
					java.lang.reflect.Field fld = fieldlist[i];
					fld.setAccessible(true);
               
					if(fld.get(this) instanceof Field)
						addField((Field) fld.get(this));
				}
				
				cls = cls.getSuperclass();
			} while (cls != null);
          } catch (Exception e) {
             e.printStackTrace();
          }
	}
	
}
