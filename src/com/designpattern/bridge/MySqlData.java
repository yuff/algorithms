package com.designpattern.bridge;

public class MySqlData implements Data {

	private String name;
	public MySqlData(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
