package mrd.data;

public abstract class AggregateField extends Field {
	/**
	 * @uml.property  name="count"
	 */
	private int count = 0;
        private AggregateType aggregateType;
	
	protected AggregateField(String fieldName, int fieldType, AggregateType aggregateType) {
		super(fieldName, fieldType);
                this.aggregateType = aggregateType;
	}
	
	public abstract void add(Object value);

	protected int getCount() { return count; }
	
	protected void increment() { count++; }

        protected void setCount(int value) { this.count = value; }

        public AggregateType getAggregateType() { return aggregateType; }
}
