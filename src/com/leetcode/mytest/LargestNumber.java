package com.leetcode.mytest;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(new int[]{0,0,0}));
		System.out.println(ln.largestNumber(new int[]{121,12,9595,959}));
		System.out.println(ln.largestNumber(new int[]{891,89176}));
	}
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int n = nums.length;
        String[] strs = new String[n];
        int i = 0;
        for(int num: nums) {
            strs[i++] = String.valueOf(num);
        }
        Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int len1 = o1.length(), len2 = o2.length();
				int lim = Math.max(len1, len2);
		        char v1[] = o1.toCharArray();
		        char v2[] = o2.toCharArray();

		        int k = 0;
		        while (k < lim) {
		            char c1 = v1[k % len1];
		            char c2 = v2[k % len2];
		            if (c1 != c2) {
		                return c1 - c2;
		            }
		            k++;
		        }
		        return o1.charAt(len1 - 1) - o2.charAt(len2 - 1);
			}
        });
        for(i = n - 1; i >=0; i--) {
            builder.append(strs[i]);
        }
        String s = builder.toString();
        return s.startsWith("0")? "0" : s;
    }
}
