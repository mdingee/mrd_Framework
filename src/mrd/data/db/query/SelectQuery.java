/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.query;

import mrd.data.Record;
import mrd.data.db.filter.AbstractFilter;
import mrd.data.db.DatabaseConnection;

/**
 *
 * @author mrdlap
 */
public abstract class SelectQuery implements Query {
    private DatabaseConnection conn;
    private Record record;
    private AbstractFilter filter;

    protected SelectQuery(DatabaseConnection conn, Record record) {
        this.conn = conn;
        this.record = record;
    }

    protected SelectQuery(DatabaseConnection conn, Record record, AbstractFilter filter) {
        this(conn, record);
        this.filter = filter;
    }

    protected Record getRecord() { return record; }

    protected DatabaseConnection getDatabaseConnection() { return conn; }

    protected AbstractFilter getRecordFilter() { return filter; }

    protected void setRecordFilter(AbstractFilter filter) { this.filter = filter; }

    protected abstract SqlBuilder getSqlBuilder();
    
}
