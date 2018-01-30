package com.designpattern.simplefactory;

public class Triangle implements Shape {

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String draw() {
		return "draw Triangle";
	}

	@Override
	public boolean erase() {
		return true;
	}

}
