package com.java8;

public class Factorial {
	private static final int SIZE = 10000;
	private static final int NUM = 10000;

	public static void main(String[] args) {

		Factorial fa = new Factorial();
		long start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			fa.factorialNoRecursive(i % NUM);
		}
		long end = System.currentTimeMillis();
		System.out.println("factorial no recursive:		" + (end - start));
		start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			fa.factorial(i % NUM, 1);
		}
		end = System.currentTimeMillis();
		System.out.println("factorial(int n, int factor):	" + (end - start));
		start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			fa.factorial(i % NUM);
		}
		end = System.currentTimeMillis();
		System.out.println("factorial(int n):		" + (end - start));
	}

	public long factorialNoRecursive(int n) {
		if (n == 0) {
			return 1;
		}
		int result = 1;
		while (n > 0) {
			result *= n;
			n--;
		}
		return result;
	}

	public long factorial(int n, int factor) {
		if (n == 0) {
			return factor;
		}
		return factorial(n - 1, n * factor);
	}

	public long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
