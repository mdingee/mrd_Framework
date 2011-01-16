/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.pgsql;

import java.util.List;
import mrd.data.Field;
import mrd.data.db.query.DeleteQuery;

/**
 *
 * @author mrdlap
 */
public class PostgresDeleteQuery extends DeleteQuery {

    public String getQuery() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Field> getConditions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
