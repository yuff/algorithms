package com.leetcode.mytest;

public class AddBinary {
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("11", "1"));
	}
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        boolean hasCarry = false;
        int m = a.length(), n = b.length(), k = Math.max(m, n);
        char[] arr = new char[k + 1];
        int i = m - 1, j = n - 1, t = k;
        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i), c2 = b.charAt(j);
            if (c1 == '0' && c2 == '0') {
                arr[t] = hasCarry? '1': '0';
                hasCarry = false;
            } else if (c1 == '1' && c2 == '1') {
                arr[t] = hasCarry? '1': '0';
                hasCarry = true;
            } else {
                if (hasCarry) {
                    arr[t] = '0';
                    hasCarry = true;
                } else {
                    arr[t] = '1';
                    hasCarry = false;
                }
            }
            i--;
            j--;
            t--;
        }
        while (i >= 0) {
            char c1 = a.charAt(i);
            if (c1 == '1') {
                if (hasCarry) {
                    arr[t] = '0';
                    hasCarry = true;
                } else {
                    arr[t] = '1';
                }
            } else {
                arr[t] = hasCarry? '1' : '0';
                hasCarry = false;
            }
            i--;
            t--;
        }
        while (j >= 0) {
            char c1 = b.charAt(j);
            if (c1 == '1') {
                if (hasCarry) {
                    arr[t] = '0';
                    hasCarry = true;
                } else {
                    arr[t] = '1';
                }
            } else {
                arr[t] = hasCarry? '1' : '0';
                hasCarry = false;
            }
            j--;
            t--;
        }
        if (hasCarry) {
            arr[0] = '1';
            return new String(arr);
        } else {
            return new String(arr, 1, k);
        }
    }
}
