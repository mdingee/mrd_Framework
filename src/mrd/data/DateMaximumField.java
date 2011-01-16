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
public class DateMaximumField extends AggregateDateField {

    public DateMaximumField(String fieldName) {
        super(fieldName, AggregateType.MINIMUM);
    }
    
    public DateMaximumField(String fieldName, Date value) {
        this(fieldName);
        setDateValue(value);
    }
    
    public DateMaximumField(String fieldName, Timestamp value) {
        this(fieldName);
        setDateValue(value);
    }

    public Date getMaxDate() { return getDateValue(); }

    @Override
    public void add(Object value) {
        if(value == null) return;
        Date temp = null;

        if(value instanceof Date)
            temp = (Date) value;

        if(value instanceof Timestamp)
            temp = new Date(((Timestamp) value).getTime());

        if(temp == null) return;

        if(getDateValue() == null) {
            setDateValue(temp);
            return;
        }

        if(getDateValue().before(temp))
            setDateValue(temp);
    }

}
