/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.filter;

import mrd.data.IntegerField;

/**
 *
 * @author mrdlap
 */
public class SimpleEqualsFilterA extends SimpleEqualsFilter {
    public SimpleEqualsFilterA() {
        super(new IntegerField("FIELD_A",1));
    }
}
