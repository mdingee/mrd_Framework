/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.query;

import java.util.List;
import mrd.data.Field;
import mrd.data.SimpleRecord;
import mrd.data.db.filter.AbstractFilter;
import mrd.data.db.DatabaseConnection;

/**
 *
 * @author mrdlap
 */
public abstract class SimpleRecordQuery extends SelectQuery {

    protected SimpleRecordQuery(DatabaseConnection conn, SimpleRecord record) {
        super(conn, record, null);
    }

    protected SimpleRecordQuery(DatabaseConnection conn, SimpleRecord record, AbstractFilter recordFilter) {
        super(conn, record, recordFilter);
    }

    @Override
    public String getQuery() {
        SqlBuilder builder = getSqlBuilder();
        return builder.select(getSimpleRecord(), getRecordFilter());
    }

    @Override
    public List <Field> getConditions() {
        if(getRecordFilter() == null) return null;
        return getRecordFilter().getConditions();
    }

    protected SimpleRecord getSimpleRecord() { return (SimpleRecord) getRecord(); }

}
