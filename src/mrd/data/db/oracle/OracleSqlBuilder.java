/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mrd.data.db.oracle;

import mrd.data.db.query.SqlBuilder;
import java.util.List;
import mrd.data.SimpleField;
import mrd.data.SimpleRecord;
import mrd.data.AggregateField;
import mrd.data.AggregateRecord;
import mrd.data.AggregateType;
import mrd.data.db.filter.AbstractFilter;

/**
 *
 * @author mrdlap
 */
public class OracleSqlBuilder extends SqlBuilder {
    private OracleSqlBuilder() {}

    /**
     * Build a SQL query based on a SimpleRecord
     * @param record
     * @param recordFilter Used in a SQL WHERE-CLAUSE
     * @return SQL query
     * @throws UnsupportedOperationException
     */
    public String select(SimpleRecord record, AbstractFilter recordFilter) throws UnsupportedOperationException {
        String selectList = null;
        String whereClause = (recordFilter == null ? null : recordFilter.getSql());
        String rslt = null;

        List <SimpleField> simpleFields = record.getSimpleFields();

        for(SimpleField each : simpleFields)
            selectList = (selectList == null ? "" : selectList + ", ") + getFieldSelect(each);

        rslt = "SELECT " + selectList + " FROM " + record.getTableName() + " ";

        rslt += (whereClause == null ? "" : " WHERE " + whereClause);

        return rslt;
    }

    /**
     * Build a SQL query based on an AggregateRecord
     * @param record
     * @param recordFilter Used in a SQL WHERE-CLAUSE
     * @param aggregateFilter Used in a SQL HAVING-CLAUSE
     * @return SQL query
     * @throws UnsupportedOperationException
     */
    public String select(AggregateRecord record, AbstractFilter recordFilter, AbstractFilter aggregateFilter) throws UnsupportedOperationException {
        String selectList = null;
        String groupList = null;
        String whereClause = (recordFilter == null ? null : recordFilter.getSql());
        String havingClause = (recordFilter == null ? null : recordFilter.getSql());
        String rslt = null;

        List <AggregateField> aggFields = record.getAggregateFields();
        List <SimpleField> simpleFields = record.getSimpleFields();

        for(SimpleField each : simpleFields) {
            selectList = (selectList == null ? "" : selectList + ", ") + getFieldSelect(each);
            groupList = (groupList == null ? "" : groupList + ", " ) + each.getFieldName();
        }

        for(AggregateField each : aggFields)
            selectList = (selectList == null ? "" : selectList + ", ") + getFieldSelect(each);

        rslt = "SELECT " + selectList + " FROM " + record.getTableName() + " ";

        rslt += (whereClause == null ? "" : " WHERE " + whereClause);
        rslt += (aggFields.isEmpty() ? "" : " GROUP BY " + groupList);
        rslt += (havingClause == null ? "" : " HAVING " + havingClause);

        return rslt;
    }

    /**
     *
     * @param field
     * @return the string representation of the sql aggregate in the form of:<BR>function(field) alias
     */
    protected String getFieldSelect(AggregateField field) {
        return getAggregateFunction(field.getAggregateType()) + "(" + field.getFieldName() + ") " + field.getFieldName();
    }

    /**
     * @param field
     * @return the string representation of a simple data field
     */
    protected String getFieldSelect(SimpleField field) { return field.getFieldName(); }

    /**
     *
     * @param type
     * @return the SQL function name for a given AggregateType
     * @throws UnsupportedOperationException
     */
    protected String getAggregateFunction(AggregateType type) throws UnsupportedOperationException {
        switch (type) {
            case SUM:
                return "SUM";
            case AVERAGE:
                return "AVG";
            case COUNT:
                return "COUNT";
            case MINIMUM:
                return "MIN";
            case MAXIMUM:
                return "MAX";
            case STRING_AGGREGATE:
                return "STRAGG";
            default:
                throw new UnsupportedOperationException("Unsupported aggregate type: " + type.name());
        }
    }
    
    public static OracleSqlBuilder getInstance() { return SingletonHolder.INSTANCE; }

    @Override
    public String insert(SimpleRecord record, AbstractFilter recordFilter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String update(SimpleRecord record, AbstractFilter recordFilter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String delete(SimpleRecord record, AbstractFilter recordFilter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static class SingletonHolder {
        public static final OracleSqlBuilder INSTANCE = new OracleSqlBuilder();
    }

}
