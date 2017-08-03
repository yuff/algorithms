package com.java8.dynamicproxy;

public class DynamicProxyTest {

	public static void main(String[] args){
		HelloWorldService service = new HelloWorldServiceImpl();
		MyInvocationHandler handler = new MyInvocationHandler(service);
		HelloWorldService proxy = (HelloWorldService) handler.getProxy();
		proxy.sayHello();
	}
}
