package com.java8;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(Fibonacci.fibonacci(3));
		System.out.println(Fibonacci.fibonacci(4));
		System.out.println(Fibonacci.fibonacci(5));
	}
	public static int fibonacci(int n) {
		if (n  <=0 ) {
			throw new RuntimeException("wrong input");
		}
		if (n ==1 || n == 2) {
			return 1;
		}
		int fn_1 = 1;
		int fn_2 = 1;
		int result = 0;
		for(int i = 0; i < n-2; i++) {
			result = fn_1 + fn_2;
			fn_2 = fn_1;
			fn_1 = result;
			
		}
		return result;
	}
}
