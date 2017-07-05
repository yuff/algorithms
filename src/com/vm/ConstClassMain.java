package com.vm;

public class ConstClassMain {
	public static final String A = "ab"; // 常量A
	public static final String B = "cd"; // 常量B

	public static void main(String[] args) {
		System.out.println(ConstClass.HELLOWORLD);
		String s = A + B; // 将两个常量用+连接对s进行初始化
		String t = "abcd";
		if (s == t) {
			System.out.println("s等于t，它们是同一个对象");
		}
		else {
			System.out.println("s不等于t，它们不是同一个对象");
		}
	}
}
