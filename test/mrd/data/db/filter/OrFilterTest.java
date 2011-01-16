/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.filter;

import java.util.ArrayList;
import mrd.data.Field;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mrdlap
 */
public class OrFilterTest {

    public OrFilterTest() { System.out.print(this.getClass().getCanonicalName() + "."); }

    /**
     * Test of getConditions method, of class OrFilter.
     */
    @Test
    public void testGetConditions() {
       System.out.println("getConditions");
        AbstractFilter filterA = new SimpleEqualsFilterA();
        AbstractFilter filterB = new SimpleEqualsFilterB();
        OrFilter instance = new OrFilter(filterA, filterB);

        List <Field> expResult = new ArrayList <Field> ();
        expResult.addAll(filterA.getConditions());
        expResult.addAll(filterB.getConditions());

        List <Field> result = instance.getConditions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSql method, of class OrFilter.
     */
    @Test
    public void testGetSql() {
        System.out.println("getSql");
        AbstractFilter filterA = new SimpleEqualsFilterA();
        AbstractFilter filterB = new SimpleEqualsFilterB();
        OrFilter instance = new OrFilter(filterA, filterB);

        String expResult = "(FIELD_A = ?) OR (FIELD_B = ?)";
        String result = instance.getSql();
        assertEquals(expResult, result);
    }

}