package mrd.data;

public abstract class Field {
	
	private int fieldType;
	private String fieldName;
	private String fieldTitle;
        private String fieldAlias;
	
	protected Field(String fieldName, int fieldType) {
		this.fieldName = fieldName;
                this.fieldType = fieldType;
	}

	public String getFieldName() { return fieldName; }
	
	public int getFieldType() { return fieldType; }
	
	public String getFieldTitle() { return fieldTitle; }

        public void setFieldTitle(String value) { fieldTitle = value; }

        public String getFieldAlias() { return fieldAlias; }

        /**
         * The fieldAlias is used in SQL queries to give an alias to the field retrieved
         * @param fieldAlias
         */
        public void setFieldAlias(String fieldAlias) { this.fieldAlias = fieldAlias; }

	public abstract void setValue(Object value);
	
	public abstract Object getValue();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Field other = (Field) obj;
        if (this.fieldType != other.fieldType) {
            return false;
        }
        if ((this.fieldTitle == null) ? (other.fieldTitle != null) : !this.fieldTitle.equals(other.fieldTitle)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.fieldType;
        hash = 13 * hash + (this.fieldName != null ? this.fieldName.hashCode() : 0);
        hash = 13 * hash + (this.fieldTitle != null ? this.fieldTitle.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Field{" + "fieldType=" + fieldType +
                        ", fieldName=" + fieldName +
                        ", fieldTitle=" + fieldTitle +
                        ", fieldAlias=" + fieldAlias + 
                        ", value=" + getValue() + "}";
    }

	
}
