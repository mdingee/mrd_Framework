package mrd.data.db.query;

import java.util.List;
import mrd.data.Field;



/**
 * @author  mrdlap
 */
public interface Query {
	public String getQuery();
	
	public List <Field> getConditions();
}
