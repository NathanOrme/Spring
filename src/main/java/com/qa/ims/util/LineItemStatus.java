package com.qa.ims.util;

public enum LineItemStatus {
	
	NORMAL(0, "Normal"), RETURNED(1, "Returned"), DAMAGED(1, "Damaged");
	
	private final long id;
	private final String name;

	LineItemStatus(long id, String name) {
		this.id = id;
		this.name = name;
	}

	// needs review
	public long getId() {
		return id;
	}

	// needs review
	public String getName() {
		return name;
	}

}
