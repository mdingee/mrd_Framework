/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.filter;

import java.util.ArrayList;
import java.util.List;
import mrd.data.Field;

/**
 *
 * @author mrdlap
 */
public abstract class SimpleFilter extends AbstractFilter {
    private Field field;

    protected SimpleFilter(Field field) {
        this.field = field;
    }

    @Override
    public List <Field> getConditions() {
        List <Field> rslt = new ArrayList <Field> ();
        rslt.add(field);
        return rslt;
    }

    @Override
    public String getSql() {
        return field.getFieldName() + " " + getOperator() + " " + "?";
    }

    protected abstract String getOperator();
}
