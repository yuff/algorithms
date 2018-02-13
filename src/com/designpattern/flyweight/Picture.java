package com.designpattern.flyweight;

public class Picture implements Document {

	private String name;
	public Picture(String name) {
		this.name = name;
	}
	@Override
	public void display(DocumentInfo info) {
		System.out.println("Picture " + name + " display postion: " + info.getX() + ", " + info.getY());
		System.out.println("Picture " + name + "display size: " + info.getHeight() + ", " + info.getWidth());
	}
	@Override
	public String getName() {
		return "Picture " + name;
	}

}
