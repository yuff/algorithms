package com.vm;

public class SubClass extends SuperClass {
	public static int subValue = 19;
	static {
		System.out.println("Subclass init!");
	}
}
