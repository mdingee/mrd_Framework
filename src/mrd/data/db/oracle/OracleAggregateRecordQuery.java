/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.oracle;

import java.util.List;
import mrd.data.Field;
import mrd.data.AggregateRecord;
import mrd.data.db.filter.AbstractFilter;
import mrd.data.db.query.AggregateRecordQuery;
import mrd.data.db.query.SqlBuilder;

/**
 *
 * @author mrdlap
 */
public class OracleAggregateRecordQuery extends AggregateRecordQuery {

    public OracleAggregateRecordQuery(OracleConnection conn, AggregateRecord record, AbstractFilter recordFilter, AbstractFilter aggregateFilter) {
        super(conn, record, recordFilter, aggregateFilter);
    }

    @Override
    protected SqlBuilder getSqlBuilder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getQuery() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Field> getConditions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
