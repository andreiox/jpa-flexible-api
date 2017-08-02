package entity;

public enum FOperator {

	EQUAL("="),
	NOT_EQUAL("!="),
	GREATER_THAN(">"),
	LESS_THAN("<"),
	GREATER_OR_EQUAL_THAN(">="),
	LESS_OR_EQUAL_THAN("<="),
	LIKE("LIKE"),
	NOT_LIKE("NOT LIKE"),
	IN("IN"),
	NOT_IN("NOT IN");

	private String jpqlOperator;

	FOperator(String jpqlOperator) {
		this.jpqlOperator = jpqlOperator;
	}

	public String getJpqlOperator() {
		return jpqlOperator;
	}

	public void setJpqlOperator(String jpqlOperator) {
		this.jpqlOperator = jpqlOperator;
	}

}
