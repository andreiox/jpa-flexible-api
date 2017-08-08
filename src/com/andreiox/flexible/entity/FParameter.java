package com.andreiox.flexible.entity;

public class FParameter {

	private String atribute;
	private FOperator operator;
	private Object value;
	private Object value2;

	public FParameter(String atribute, FOperator operator) {
		this.atribute = atribute;
		this.operator = operator;
	}

	public FParameter(String atribute, FOperator operator, Object value) {
		this(atribute, operator);
		this.value = value;
	}

	public FParameter(String atribute, FOperator operator, Object value1, Object value2) {
		this(atribute, operator, value1);
		this.value2 = value2;
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

	public Object getValue2() {
		return value2;
	}

	public void setValue2(Object value2) {
		this.value2 = value2;
	}

}
