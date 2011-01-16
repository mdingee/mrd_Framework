package mrd.data;

public abstract class RecordFactory {
	
	/**
	 * @return The record type used to retrieve data from the database
	 */
	public abstract Record getRecord();
}
