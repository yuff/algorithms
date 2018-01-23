package com.leetcode.mytest;

import java.util.LinkedList;

public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("(("));
		System.out.println(vp.isValid("(])[(]{}"));
	}
	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		int n = s.length();
		if (n % 2 != 0) {
			return false;
		}
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (isLeft(c)) {
				stack.push(c);
			}
			else {
				if (stack.isEmpty() || !isPair(stack.pop(), c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private boolean isPair(char t, char c) {
		return (t == '(' && c == ')') || (t == '[' && c == ']') || (t == '{' && c == '}');
	}

	private boolean isLeft(char c) {
		return c == '(' || c == '[' || c == '{';
	}
}
