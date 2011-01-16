/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.oracle;

import mrd.data.SimpleRecord;
import mrd.data.db.filter.AbstractFilter;
import mrd.data.db.query.SimpleRecordQuery;
import mrd.data.db.query.SqlBuilder;

/**
 *
 * @author mrdlap
 */
public class OracleSimpleRecordQuery extends SimpleRecordQuery {

    public OracleSimpleRecordQuery(OracleConnection conn, SimpleRecord record) {
        super(conn, record);
    }

    public OracleSimpleRecordQuery(OracleConnection conn, SimpleRecord record, AbstractFilter recordFilter) {
        super(conn, record, recordFilter);
    }

    @Override
    protected SqlBuilder getSqlBuilder() { return OracleSqlBuilder.getInstance(); }

}
