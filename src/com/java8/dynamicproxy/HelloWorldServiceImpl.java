package com.java8.dynamicproxy;

public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String sayHello() {
		System.out.println("Hello World");
		return "Hello World";
	}

}
