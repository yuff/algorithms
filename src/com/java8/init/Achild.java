package com.java8.init;

public class Achild extends AbstractParent {
//	static {
//		System.out.println("static block" + AbstractParent.size);
//	}
	String state = "child";

	public static void main(String[] args) {
//		System.out.println("main" + AbstractParent.size);
		Achild ac = new Achild();
		System.out.println(ac.state);
		ac.setState("ddd");
		System.out.println(ac.getState());
	}
}
