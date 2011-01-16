/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.filter;

import java.util.List;
import mrd.data.Field;

/**
 *
 * @author mrdlap
 */
public abstract class AbstractFilter {
    public abstract String getSql();
    
    public abstract List <Field> getConditions();
}
