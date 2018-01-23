package com.java8.init;

class Test {
	int c;
	Test(String name, int c) {
		System.out.println(name + " call test constructor");
		this.c = c;
	}
}
public class StaticInit {
	Test t = new Test("obj", 0);
	static Test st = new Test("static", 0);
	static {
		System.out.println("statck block," + st.c);
	}
	public StaticInit(String name) {
		System.out.println("StaticInit constructor" + name);
	}
	public static void main(String[] args) {
		StaticInit si = new StaticInit("si");
		StaticInit si1 = new StaticInit("si1");
	}
}
