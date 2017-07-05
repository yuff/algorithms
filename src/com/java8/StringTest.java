package com.java8;

public class StringTest {

	public static void main(String[] agrs) {
		String s1 = "hello world";
		String s2 = new String("hello world");
		System.out.println(s1 == s2);
		
		String str1 = "str";
		String str2 = "ing";

		String str3 = "str" + "ing";
		String str4 = str1 + str2;
		System.out.println(str3 == str4);//false

		String str5 = "string";
		System.out.println(str3 == str5);//true
		
		int a = Integer.MAX_VALUE;
//		int b = Math.addExact(a, 1);
		System.out.println(a);
	}
}
