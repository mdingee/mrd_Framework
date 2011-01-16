/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrdlap
 */
public abstract class SimpleRecord extends Record {
    protected SimpleRecord(String tableName) { super(tableName); }

    public List <SimpleField> getSimpleFields() {
        List <SimpleField> rslt = new ArrayList <SimpleField> ();

        List <Field> fields = getFields();

        for(Field each : fields)
            if(each instanceof SimpleField)
                rslt.add((SimpleField) each);

        return rslt;
    }
}
