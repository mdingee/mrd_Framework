/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.filter;

import mrd.data.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mrdlap
 */
public class AndFilterTest {

    public AndFilterTest() { System.out.print(this.getClass().getCanonicalName() + "."); }


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getConditions method, of class AndFilter.
     */
    @Test
    public void testGetConditions() {
        System.out.println("getConditions");
        AbstractFilter filterA = new SimpleEqualsFilterA();
        AbstractFilter filterB = new SimpleEqualsFilterB();
        AndFilter instance = new AndFilter(filterA, filterB);

        List <Field> expResult = new ArrayList <Field> ();
        expResult.addAll(filterA.getConditions());
        expResult.addAll(filterB.getConditions());

        List <Field> result = instance.getConditions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSql method, of class AndFilter.
     */
    @Test
    public void testGetSql() {
        System.out.println("getSql");
        AbstractFilter filterA = new SimpleEqualsFilterA();
        AbstractFilter filterB = new SimpleEqualsFilterB();
        AndFilter instance = new AndFilter(filterA, filterB);

        String expResult = "(FIELD_A = ?) AND (FIELD_B = ?)";
        String result = instance.getSql();
        assertEquals(expResult, result);
    }

}