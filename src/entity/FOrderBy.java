package entity;

public class FOrderBy {

	private String[] attributes;
	private FSortOrder sortOrder;

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
