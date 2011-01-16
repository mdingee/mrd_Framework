package mrd;

import java.util.HashMap;
import java.util.Iterator;

public abstract class TranslationMap {
	/**
	 * @uml.property  name="_map"
	 */
	private HashMap <Object, Object> _map = new HashMap <Object, Object>();
	/**
	 * @uml.property  name="_missingEntries"
	 * @uml.associationEnd  qualifier="key:java.lang.Object java.lang.Integer"
	 */
	private HashMap <Object, Integer> _missingEntries = new HashMap <Object, Integer> ();
	/**
	 * @uml.property  name="_translatedEntries"
	 * @uml.associationEnd  qualifier="key:java.lang.Object java.lang.Integer"
	 */
	private HashMap <Object, Integer> _translatedEntries = new HashMap <Object, Integer> ();
	/**
	 * @uml.property  name="_mapName"
	 */
	private String _mapName;
	
	protected TranslationMap(String mapName) {
		_mapName = mapName;
		try { load(); }
		catch (Exception e) { 
			System.out.println("ProductMap: Exception in load()"); 
			e.printStackTrace(); 
		}
	}

	public Object get(Object key) {
		if(_map.containsKey(key)) {
			success(key);
			return _map.get(key);
		} else {
			failure(key);
			return null;
		}
	}
	
	protected abstract void load() throws Exception;
	
	protected int getCount() { return _map.size(); }
	
	protected void flush() { 
		_map = null;
		_map = new HashMap <Object, Object>(); 
	}
	
	
	@SuppressWarnings("unchecked")
	public void printAll() {
		System.out.print("Printing map " + _mapName);
		Iterator i = _map.keySet().iterator();
		while(i.hasNext()) {
			Object key =  i.next();
			Object val =  _map.get(key);
			System.out.println(key.toString() + " trx " + (val == null ? "<NULL>" : val.toString()));
		}
	}
	
	protected boolean containsKey(Object key) {
		return (_map.containsKey(key));
	}
	
	protected void set(Object key, Object value) {
		if(! _map.containsKey(key)) 
			_map.put(key, value);
	}
	
	public String getName() { return _mapName; }
	
	private void success(Object key) {
		if(_translatedEntries.containsKey(key)) {
			Integer newVal = Integer.valueOf(_translatedEntries.get(key).intValue() + 1);
			_translatedEntries.remove(key);
			_translatedEntries.put(key, newVal);
		} else {
			_translatedEntries.put(key, Integer.valueOf(1));
		}
			
	}
	
	private void failure(Object key) {
		if(_missingEntries.containsKey(key)) {
			Integer newVal = Integer.valueOf(_missingEntries.get(key).intValue() + 1);
			_missingEntries.remove(key);
			_missingEntries.put(key, newVal);
		} else {
			_missingEntries.put(key, Integer.valueOf(1));
		}
	}
	
	public void printResults() {
		System.out.println("Mapping results for " + _mapName);
		Iterator <Object> i = _missingEntries.keySet().iterator();
		
		System.out.println("     Missing map entries:");
		while(i.hasNext()) {
			Object key = i.next();
			try { System.out.println("       " + (key == null ? "<NULL>" : key.toString()) + " x " + _missingEntries.get(key)); }
			catch (Exception e) { e.printStackTrace(); }
		}	
		
		Iterator <Object> j = _translatedEntries.keySet().iterator();
			
		System.out.println("     Translated map entries:");
		while(j.hasNext()) {
			Object key = j.next();
			try { System.out.println("       " + (key == null ? "<NULL>" : key.toString()) + " = " + _map.get(key).toString() + " x " + _translatedEntries.get(key)); }
			catch (Exception e) {e.printStackTrace(); }
		}
		//i = null;
		
	}
	
}
