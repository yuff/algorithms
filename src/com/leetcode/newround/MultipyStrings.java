package com.leetcode.newround;

public class MultipyStrings {
	public static void main(String[] args) {
		MultipyStrings ms = new MultipyStrings();
		System.out.println(ms.multiply("25000", "3500000"));
		System.out.println(ms.multiply("11", "7"));
		System.out.println(ms.multiply("4", "7"));
		System.out.println(ms.multiply("1", "0"));
		System.out.println(ms.multiply("1", "99"));
	}
    public String multiply(String num1, String num2) {
        int c1 = countEndZero(num1);
        int c2 = countEndZero(num2);
        String s1 = num1.substring(0, num1.length() - c1);
        String s2 = num2.substring(0, num2.length() - c2);
        if (s1.length() == 0 || s2.length() == 0) {
        	return new String("0");
        }
        int n = s1.length() + s2.length() - 1;
        int[] r = new int[n];
        for(int i = 0; i  < s1.length(); i++) {
        	for(int j = 0; j < s2.length(); j++) {
        		int v1 = s1.charAt(i) - '0', v2 = s2.charAt(j) - '0';
        		r[i + j] += (v1 * v2);
        	}
        }
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
        	int value = r[i] + add;
        	add = value / 10;
        	r[i] = value % 10;
        }
        if (add > 0) {
        	sb.append(add);
        }
        for(int i = 0; i < n; i++) {
        	sb.append(r[i]);
        }
        int c = c1 + c2;
        while (c > 0) {
        	sb.append(0);
        	c--;
        }
        return sb.toString();
    }

	private int countEndZero(String s) {
		int n = s.length(), count = 0;
		for(int i = n - 1; i >=0;i--) {
			if (s.charAt(i) == '0') {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}
