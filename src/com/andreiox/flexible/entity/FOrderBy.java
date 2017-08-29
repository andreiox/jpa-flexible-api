package com.andreiox.flexible.entity;

public class FOrderBy {

	private String[] attributes;
	private FSortOrder sortOrder;

	public FOrderBy() {
		sortOrder = FSortOrder.ASC;
	}

	public FOrderBy(FSortOrder sortOrder, String... attributes) {
		this.sortOrder = sortOrder;
		this.attributes = attributes;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String... attributes) {
		this.attributes = attributes;
	}

	public FSortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(FSortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}
}
