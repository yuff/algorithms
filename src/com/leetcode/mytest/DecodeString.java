package com.leetcode.mytest;

public class DecodeString {
	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
		System.out.println(ds.decodeString("3[a]2[bc]").equals("aaabcbc"));
		System.out.println(ds.decodeString("3[a2[c]]").equals("accaccacc"));
	}
	public String decodeString(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		int len = s.length();
		int index = 0;
		while (index < len) {
			char c = s.charAt(index);
			if (c >= '0' && c <= '9') {
				int repeat = 0;
				while (c >= '0' && c <= '9') {
					repeat = repeat * 10 + (c - '0');
					index++;
					if (index >= len) {
						throw new RuntimeException("error input format!");
					}
					c = s.charAt(index);
				}
				int start, end;
				String child = null;
				if (c == '[') {
					start = index + 1;
					end = findEnd(s, index);
					child = decodeString(new String(s.toCharArray(), start, end - start));
					while (repeat > 0) {
						builder.append(child);
						repeat--;
					}
					index = end + 1;
				}
			}
			else {
				builder.append(c);
				index++;
			}
		}
		return builder.toString();
	}

	private int findEnd(String s, int index) {
		int len = s.length();
		int result = -1;
		int count = 0;
		if (s.charAt(index) == '[') {
			count = 1;
		}
		for (int i = index + 1; i < len; i++) {
			if (s.charAt(i) == '[') {
				count++;
			}
			else if (s.charAt(i) == ']') {
				count--;
			}
			if (count == 0) {
				result = i;
				break;
			}
		}
		return result;
	}
}
