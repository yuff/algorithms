package com.designpattern.simplefactory;

public class Square implements Shape {

	public Square() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String draw() {
		return "draw Square";
	}

	@Override
	public boolean erase() {
		return true;
	}

}
