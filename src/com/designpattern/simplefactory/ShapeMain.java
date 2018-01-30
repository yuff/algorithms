package com.designpattern.simplefactory;

public class ShapeMain {

	public static void main(String[] args) {
		Shape circle = ShapeFactory.getShape("Circle");
		System.out.println(circle.draw());
		Shape triangle = ShapeFactory.getShape("triangle");
		System.out.println(triangle.draw());
		Shape rectangle = ShapeFactory.getShape("rectangle");
		System.out.println(rectangle.draw());
	}
}
