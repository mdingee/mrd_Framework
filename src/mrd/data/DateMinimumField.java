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
public class DateMinimumField extends AggregateDateField {

    public DateMinimumField(String fieldName) {
        super(fieldName, AggregateType.MINIMUM);
    }
    
    public DateMinimumField(String fieldName, Date value) {
        this(fieldName);
        setDateValue(value);
    }
    
    public DateMinimumField(String fieldName, Timestamp value) {
        this(fieldName);
        setDateValue(value);
    }

    public Date getMinDate() { return getDateValue(); }

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

        if(getDateValue().after(temp))
            setDateValue(temp);
    }

}
