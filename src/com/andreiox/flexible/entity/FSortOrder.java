package com.andreiox.flexible.entity;

public enum FSortOrder {

	ASC("asc"),
	DESC("desc");

	private String jpqlSyntax;

	FSortOrder(String jpqlSyntax) {
		this.setJpqlSyntax(jpqlSyntax);
	}

	public String getJpqlSyntax() {
		return jpqlSyntax;
	}

	public void setJpqlSyntax(String jpqlSintaxe) {
		this.jpqlSyntax = jpqlSintaxe;
	}
}
