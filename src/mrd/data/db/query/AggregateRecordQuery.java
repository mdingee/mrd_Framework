/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.query;

import mrd.data.AggregateRecord;
import mrd.data.db.filter.AbstractFilter;
import mrd.data.db.DatabaseConnection;

/**
 *
 * @author mrdlap
 */
public abstract class AggregateRecordQuery extends SelectQuery  {
    private AbstractFilter aggregateFilter;

    protected AggregateRecordQuery(DatabaseConnection conn, AggregateRecord record) {
        super(conn, record);
    }

    protected AggregateRecordQuery(DatabaseConnection conn, AggregateRecord record, AbstractFilter recordFilter) {
        super(conn, record, recordFilter);
    }

    protected AggregateRecordQuery(DatabaseConnection conn, AggregateRecord record, AbstractFilter recordFilter, AbstractFilter aggregateFilter) {
        this(conn, record, recordFilter);
        this.aggregateFilter = aggregateFilter;
    }

    public AbstractFilter getAggregateFilter() { return aggregateFilter; }

    public void setAggregateFilter(AbstractFilter aggregateFilter) { this.aggregateFilter = aggregateFilter; }

    protected AggregateRecord getAggregateRecord() { return (AggregateRecord) getRecord(); }

}
