package com.leetcode.mytest;

public class LicenseKeyFormatting {
	public static void main(String[] args) {
		LicenseKeyFormatting lf = new LicenseKeyFormatting();
		System.out.println(lf.licenseKeyFormatting("---", 2));
		System.out.println(lf.licenseKeyFormatting("2-4A0r7-4k", 8));
	}

	public String licenseKeyFormatting(String S, int K) {
		String s1 = S.toUpperCase();
		int len = s1.length();
		int realCount = 0;
		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) != '-') {
				realCount++;
			}
		}
		int rLen = realCount + realCount / K;
		if (rLen == 0) {
			return "";
		}
		char[] cArray = new char[rLen];
		int count = K;
		int index = rLen - 1;
		int i = len - 1;
		while (i >= 0) {
			char c = s1.charAt(i);
			if (c == '-') {
				i--;
				continue;
			}
			else {
				if (count > 0) {
					cArray[index--] = c;
					count--;
				}
				if (count == 0 && index >= 0) {
					cArray[index--] = '-';
					count = K;
				}
				i--;
			}
		}
		int offset = cArray[index + 1] == '-' ? index + 2 : index + 1;
		int c = rLen - offset;
		return new String(cArray, offset, c);
	}
}
