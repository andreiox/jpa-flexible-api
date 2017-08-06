package entity;

public class FParameter<T> {

	private String atribute;
	private FOperator operator;
	private T value;

	public FParameter(String atribute, FOperator operator, T value) {
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

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
