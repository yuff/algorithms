package com.leetcode.mytest;

public class MagicalString {

	public static void main(String[] args) {
		MagicalString ms = new MagicalString();
		System.out.println(ms.magicString(7));
	}
	public int magicString(int n) {
		int result = 0;
		int i = 0;
		int length = 0;
		StringBuilder b = new StringBuilder();
		while (length < n) {
			b.append(i % 2 == 0 ? 1 : 2);
			int num = b.charAt(i) - '0';
			if (i % 2 == 0) {
				result++;
				length++;
				i++;
				while (num > 1 && length < n) {
					b.append(1);
					num--;
					length++;
					result++;
				}
			}
			else {
				i++;
				length++;
				while (num > 1 && length < n) {
					b.append(2);
					num--;
					length++;
				}
			}
		}
		return result;
	}
}
