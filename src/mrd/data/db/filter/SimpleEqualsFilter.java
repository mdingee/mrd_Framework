/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.filter;

import mrd.data.Field;

/**
 *
 * @author mrdlap
 */
public class SimpleEqualsFilter extends SimpleFilter {

    public SimpleEqualsFilter(Field field) {
        super(field);
    }

    public String getOperator() { return "="; }
}
