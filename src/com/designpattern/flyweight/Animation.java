package com.designpattern.flyweight;

public class Animation implements Document {

	private String name;

	public Animation(String name) {
		this.name = name;
	}
	@Override
	public void display(DocumentInfo info) {
		System.out.println("Animation" + name + " display postion: " + info.getX() + ", " + info.getY());
		System.out.println("Animation" + name + " display size: " + info.getHeight() + ", " + info.getWidth());
	}
	@Override
	public String getName() {
		return "Animation " + name;
	}

}
