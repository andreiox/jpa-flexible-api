package entity;

public class FParameter<T> {

	private String atribute;
	private FOperator operator;
	private T[] values;

	public FParameter(String atribute, FOperator operator, @SuppressWarnings("unchecked") T... values) {
		this.atribute = atribute;
		this.operator = operator;
		this.values = values;
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

	public T[] getValues() {
		return values;
	}

	public void setValues(T[] values) {
		this.values = values;
	}

}
