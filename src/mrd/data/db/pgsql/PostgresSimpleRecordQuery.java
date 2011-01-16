/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.pgsql;

import mrd.data.SimpleRecord;
import mrd.data.db.filter.AbstractFilter;
import mrd.data.db.query.SimpleRecordQuery;
import mrd.data.db.query.SqlBuilder;

/**
 *
 * @author mrdlap
 */
public class PostgresSimpleRecordQuery extends SimpleRecordQuery {

    public PostgresSimpleRecordQuery(PostgresConnection conn, SimpleRecord record) {
        super(conn, record);
    }

    public PostgresSimpleRecordQuery(PostgresConnection conn, SimpleRecord record, AbstractFilter recordFilter) {
        super(conn, record, recordFilter);
    }

    @Override
    protected SqlBuilder getSqlBuilder() { return PostgresSqlBuilder.getInstance(); }

}
