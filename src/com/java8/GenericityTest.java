package com.java8;

import java.util.List;

public class GenericityTest {

	public String method(List<String> slist) {
		System.out.println("invoke method method(List<String> slist)");
		return "";
	}
	
	public int method1(List<Integer> slist) {
		System.out.println("invoke method method(List<String> slist)");
		return 1;
	}
	
	public static void main(String[] args) {
		new GenericityTest().test();
		new GenericityTest().test1();
	}
    public void test() {
    	long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "asjdkla";
        }
        long timeConsume = System.currentTimeMillis() - start;
        System.out.println("test + using time:" + timeConsume);
    }
    
    public void test1() {
    	long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("asjdkla".length() * 10000);
        for (int i = 0; i < 10000; i++) {
            sb.append("asjdkla");
        }
        String str = sb.toString();
        long timeConsume = System.currentTimeMillis() - start;
        System.out.println("test + using time:" + timeConsume);
    }
}
