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
public class SimpleEqualsFilterB extends SimpleEqualsFilter {
    public SimpleEqualsFilterB() {
        super(new IntegerField("FIELD_B",2));
    }
}
