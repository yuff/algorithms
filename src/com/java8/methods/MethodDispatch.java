package com.java8.methods;

import java.io.Serializable;

public class MethodDispatch {

	public void sayHello(Human human) {
		System.out.println("hello human");
	}
	
	public void sayHello(Man human) {
		System.out.println("hello man");
	}
	
	public void sayHello(Woman human) {
		System.out.println("hello woman");
	}
	
	public void sayHello(char c) {
		System.out.println("hello char");
	}
	
	public void sayHello(Character c) {
		System.out.println("hello Character");
	}
	
	public void sayHello(Serializable c) {
		System.out.println("hello Serializable");
	}
	
	public void sayHello(Comparable<? extends Object> c) {
		System.out.println("hello Comparable");
	}
	public static void main(String[] args) {
		MethodDispatch md = new MethodDispatch();
		md.sayHello('a');
		Human man = new Man();
		Human woman = new Woman();
		
		
		Man man1 = new Man();
		Woman woman1 = new Woman();
		
		md.sayHello(man);
		md.sayHello((Woman)woman);
		md.sayHello(man1);
		md.sayHello((Human)woman1);
	}
}
