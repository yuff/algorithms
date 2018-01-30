package com.designpattern.simplefactory;

public class Circle implements Shape {

	public Circle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String draw() {
		return "draw Circle";
	}

	@Override
	public boolean erase() {
		return true;
	}

}
