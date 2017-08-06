package entity;

public class FParameter {

	private String atribute;
	private FOperator operator;
	private Object value;

	public FParameter(String atribute, FOperator operator, Object value) {
		this.atribute = atribute;
		this.operator = operator;
		this.setValue(value);
	}

	public String getAtribute() {
		return atribute;
	}

	public void setAtribute(String atribute) {
		this.atribute = atribute;
	}

	public FOperator getOperator() {
		return operator;
	}

	public void setOperator(FOperator operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
