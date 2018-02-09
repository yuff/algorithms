package com.designpattern.bridge;

public class OracleData implements Data {

	private String name;

	public OracleData(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
