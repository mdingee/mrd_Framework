/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.query;

import mrd.data.SimpleRecord;
import mrd.data.AggregateRecord;
import mrd.data.db.filter.AbstractFilter;

/**
 *
 * @author mrdlap
 */
public abstract class SqlBuilder {

    /**
     * Build a SQL query based on a SimpleRecord
     * @param record
     * @param recordFilter Used in a SQL WHERE-CLAUSE
     * @return SQL query
     * @throws UnsupportedOperationException
     */
    public abstract String select(SimpleRecord record, AbstractFilter recordFilter) throws UnsupportedOperationException;

    public abstract String insert(SimpleRecord record, AbstractFilter recordFilter);

    public abstract String update(SimpleRecord record, AbstractFilter recordFilter);

    public abstract String delete(SimpleRecord record, AbstractFilter recordFilter);

    /**
     * Build a SQL query based on an AggregateRecord
     * @param record
     * @param recordFilter Used in a SQL WHERE-CLAUSE
     * @param aggregateFilter Used in a SQL HAVING-CLAUSE
     * @return SQL query
     * @throws UnsupportedOperationException
     */
    public abstract String select(AggregateRecord record, AbstractFilter recordFilter, AbstractFilter aggregateFilter) throws UnsupportedOperationException;

}
