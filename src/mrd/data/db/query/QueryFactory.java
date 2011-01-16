/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.query;

import mrd.data.SimpleRecord;
import mrd.data.AggregateRecord;
import mrd.data.db.DatabaseConnection;

/**
 *
 * @author mrdlap
 */
public abstract class QueryFactory {
    private DatabaseConnection conn;

    protected QueryFactory(DatabaseConnection conn) {
        this.conn = conn;
    }

    protected DatabaseConnection getDatabaseConnection() { return conn; }

    public abstract SelectQuery getSelectQuery(AggregateRecord record);

    public abstract SelectQuery getSelectQuery(SimpleRecord record);

    public abstract InsertQuery getInsertQuery(SimpleRecord record);

    public abstract UpdateQuery getUpdateQuery(SimpleRecord record);

    public abstract DeleteQuery getDeleteQuery(SimpleRecord record);
}
