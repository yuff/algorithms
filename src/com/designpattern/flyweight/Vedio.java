package com.designpattern.flyweight;

public class Vedio implements Document {

	private String name;

	public Vedio(String name) {
		this.name = name;
	}
	@Override
	public void display(DocumentInfo info) {
		System.out.println("Vedio" + name + " display postion: " + info.getX() + ", " + info.getY());
		System.out.println("Vedio" + name + "display size: " + info.getHeight() + ", " + info.getWidth());
	}
	@Override
	public String getName() {
		return "Vedio " + name;
	}

}
