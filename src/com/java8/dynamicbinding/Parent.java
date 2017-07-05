package com.java8.dynamicbinding;

public class Parent {

	static String parent = "parent";
	public Parent() {
		System.out.println("parent init");
	}
	public static void print() {
		System.out.println("parent print");
	}
}
