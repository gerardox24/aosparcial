package com.hamp.entities;

public enum Level {

	LEVEL5("very goog"),
	LEVEL4("good"),
	LEVEL3("regular"),
	LEVEL2("bad"),
	LEVEL1("very bad");
	
	
	private String name;

	
	private Level(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
