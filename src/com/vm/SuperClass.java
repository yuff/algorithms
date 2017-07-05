package com.vm;

public class SuperClass {

	public SuperClass() {
		System.out.println("SuperClass constructor");
	}
	static {
		System.out.println("Super Class Init!");
	}
	public static int value = 9;
}
