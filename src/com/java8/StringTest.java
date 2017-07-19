package com.java8;

import java.math.BigDecimal;

public class StringTest {

	public static void main(String[] agrs) {
		// String s1 = "hello world";
		// String s2 = new String("hello world");
		// System.out.println(s1 == s2);
		//
		// String str1 = "str";
		// String str2 = "ing";
		//
		// String str3 = "str" + "ing";
		// String str4 = str1 + str2;
		// System.out.println(str3 == str4);//false
		//
		// String str5 = "string";
		// System.out.println(str3 == str5);//true
		//
		// int a = Integer.MAX_VALUE;
		//// int b = Math.addExact(a, 1);
		// System.out.println(a);

		double f1 = 0.2;
		double f2 = 0.4;
		double f3 = 0.6;
		BigDecimal d1 = new BigDecimal("0.1");
//		BigDecimal d1 = BigDecimal.valueOf(0.1);
		BigDecimal d2 = BigDecimal.valueOf(0.2);
		BigDecimal d3 = BigDecimal.valueOf(0.3);
		System.out.println(d1.add(d2).toString());
		System.out.println(d3.toString());
		System.out.println(d3.equals(d1.add(d2)));
		System.out.println(f1 + f2 == f3);
		System.out.println(0.2f + 0.4f == 0.6f);
	}
}
