package com.java8.init;

public class Child extends Parent {
	static Test st = new Test("Child static", 1);
	Test t = new Test("Child obj", 2);
	static {
		System.out.println("Child static block," + st.c);
	}
	public Child() {
		System.out.println("Child constructor");
	}
	
	public static void main(String[] args) {
		System.out.println(Parent.st.c);
		Child c = new Child();
		System.out.println(c.st.c);
	}
}
