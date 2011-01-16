/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.pgsql;

import mrd.data.SimpleRecord;
import mrd.data.AggregateRecord;
import mrd.data.db.query.DeleteQuery;
import mrd.data.db.query.InsertQuery;
import mrd.data.db.query.QueryFactory;
import mrd.data.db.query.SelectQuery;
import mrd.data.db.query.UpdateQuery;

/**
 *
 * @author mrdlap
 */
public class PostgresQueryFactory extends QueryFactory {

    public PostgresQueryFactory(PostgresConnection conn) {
        super(conn);
    }

    @Override
    public SelectQuery getSelectQuery(AggregateRecord record) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SelectQuery getSelectQuery(SimpleRecord record) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InsertQuery getInsertQuery(SimpleRecord record) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UpdateQuery getUpdateQuery(SimpleRecord record) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DeleteQuery getDeleteQuery(SimpleRecord record) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
