package com.leetcode.mytest;

public class ReverseStringII {
	public static void main(String[] args) {
		ReverseStringII rs = new ReverseStringII();
		System.out.println(rs.reverseStr("abcdefg", 2));
	}

	public String reverseStr(String s, int k) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		char[] c = s.toCharArray();
		int n = s.length();
		boolean needReverse = true;
		int i = 0;
		while (i < n) {
			if (needReverse) {
				int start = i;
				int end = Math.min(n - 1, i + k - 1);
				reverse(c, start, end);
				needReverse = false;
				i = end + 1;
			}
			else {
				i += k;
				needReverse = true;
			}
		}
		return new String(c);
	}

	private void reverse(char[] c, int start, int end) {
		while(end > start) {
			char tmp = c[start];
			c[start] = c[end];
			c[end] = tmp;
			start++;
			end--;
		}
	}
}
