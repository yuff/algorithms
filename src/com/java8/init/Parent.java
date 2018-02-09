package com.java8.init;

public class Parent {
	static Test st = new Test("Parent static", 0);
	static {
		System.out.println("Parent static block," + st.c);
	}
	public Parent() {
		System.out.println("Parent constructor");
	}
	
	public final void print() {
		System.out.println("parent print");
	}
	static class StaticChild {
		Test t = new  Test("StaticChild obj", 1);
		static Test sst = new Test("StaticChild static", 0);
		static {
			System.out.println("Parent st:" + st.c);
			System.out.println("StaticChild static block," + sst.c);
		}
	}
	public static void main(String[] args) {
		Parent p = new Parent();
		Parent p1 = new Parent();
		Parent.StaticChild ps = new Parent.StaticChild();
		Parent.StaticChild ps1 = new Parent.StaticChild();
	}
}
