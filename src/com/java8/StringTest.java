package com.java8;

import java.util.Random;

public class StringTest {
	Integer pi = 9999;
	final Integer pfi = 555;
	static final Integer psfi = 1000;
	static final String pfs = "abc";
	
	String ps = "abcefg";
	final Integer pfin;

	public StringTest() {
		this.pfin = new Random().nextInt();
	}

	public static void main(String[] agrs) {
		StringTest st1 = new StringTest();
		StringTest st2 = new StringTest();
		
		Integer a = 555;
		Integer b = 555;
		System.out.println(a == b);
		System.out.println(pfs == "ab" + "c");
//		System.out.println(st1.pfi == st2.pfi);
//		System.out.println(st1.ps == st2.ps);
//		System.out.println(st1.pfin == st2.pfin);
//		System.out.println(st1.ps == new SubTest().ps);
	}
}
