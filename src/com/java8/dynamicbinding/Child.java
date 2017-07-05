package com.java8.dynamicbinding;

public class Child extends Parent{
	public Child() {
		System.out.println("child init");
	}
	
	public static void print() {
		System.out.println("child print");
	}
}
