package com.java8.init;

public class IChildChild implements IChild, IChild1 {
	static {
		System.out.println("child class static");
	}
}
