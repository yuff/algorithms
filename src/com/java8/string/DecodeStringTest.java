package com.java8.string;

public class DecodeStringTest {

	public static void main(String[] args) {
		DecodeStringTest dst = new DecodeStringTest();
		System.out.println(dst.decodeString("3[a]2[bc]"));
		System.out.println(dst.decodeString("3[a2[c]]"));
		System.out.println(dst.decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
	}
	public String decodeString(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		String repeat = null;
		int n = s.length(), i = 0, co = 0;
		while (i < n) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				co = (co * 10) + (c - '0');
				i++;
			} else if (c == '[') {
				int[] tmp = new int[]{i};
				repeat = decodeString(parseString(s, tmp));
				i = tmp[0];
				while (co > 0) {
					builder.append(repeat);
					co--;
				}
			} else if (c != ']') {
				builder.append(c);
				i++;
			}
		}
		return builder.toString();
	}

	private String parseString(String s, int[] id) {
		int start = id[0], i = start + 1, count = 1, n = s.length();
		while (i < n) {
			char c = s.charAt(i);
			if (c == '[') {
				count++;
			} else if (c == ']') {
				count--;
				if (count == 0) {
					id[0] = i + 1;
					 break;
				}
			}
			i++;
		}
		return new String(s.toCharArray(), start + 1, i - start - 1);
	}
}
