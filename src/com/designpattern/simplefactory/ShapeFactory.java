package com.designpattern.simplefactory;

public class ShapeFactory {

	public ShapeFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Shape getShape(String name) {
		if ("Square".equalsIgnoreCase(name)) {
			return new Square();
		} else if ("Circle".equalsIgnoreCase(name)) {
			return new Circle();
		} else if ("Triangle".equalsIgnoreCase(name)) {
			return new Triangle();
		} else {
			throw new UnSupportedShapeException();
		}
	}
}
