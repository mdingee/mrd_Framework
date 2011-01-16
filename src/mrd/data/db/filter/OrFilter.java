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
public class OrFilter extends AbstractFilter {
    private AbstractFilter first;
    private AbstractFilter second;

    public OrFilter(AbstractFilter first, AbstractFilter second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public List <Field> getConditions() {
        List <Field> rslt = new ArrayList <Field> ();
        rslt.addAll(first.getConditions());
        rslt.addAll(second.getConditions());
        return rslt;
    }

    @Override
    public String getSql() {
        return "(" + first.getSql() + ")" + " OR " + "(" + second.getSql()+ ")";
    }

}
