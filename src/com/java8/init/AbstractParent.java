package com.java8.init;

public abstract class AbstractParent {
	String state;

	AbstractParent() {
		state = "init";
	}
	public String getState() {
		return state;
	}
	
	public void setState(String str) {
		this.state = str;
	}

}
