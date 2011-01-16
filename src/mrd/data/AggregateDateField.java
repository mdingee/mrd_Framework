/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author mrdlap
 */
public abstract class AggregateDateField extends AggregateField {
    private Date value;

    protected AggregateDateField(String fieldName, AggregateType aggregateType) {
        super(fieldName, java.sql.Types.DATE, aggregateType);
    }

    protected AggregateDateField(String fieldName, AggregateType aggregateType, Date value) {
        this(fieldName, aggregateType);
        this.value = value;
    }

    protected AggregateDateField(String fieldName, AggregateType aggregateType, Timestamp value) {
        this(fieldName, aggregateType);

        if(value == null) return;
	this.value = new Date(value.getTime());
    }

    protected java.sql.Date getDateValue() { return (java.sql.Date) getValue(); }

    protected void setDateValue(java.sql.Date value) { setValue(value); }

    protected void setDateValue(java.sql.Timestamp value) {
        if(value == null) setValue(value);
	else setValue(new Date(value.getTime()));
    }

    @Override
    public Object getValue() { return value; }

    @Override
    public void setValue(Object value) {
        if(value == null) {
            this.value = null;
            return;
        }

        if(value instanceof java.sql.Timestamp)
            setDateValue((java.sql.Timestamp) value);

        if(value instanceof java.sql.Date)
            setDateValue((java.sql.Date) value);
        
    }

}
