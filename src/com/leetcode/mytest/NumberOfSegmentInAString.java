package com.leetcode.mytest;

public class NumberOfSegmentInAString {
	public static void main(String[] args) {
		NumberOfSegmentInAString nos = new NumberOfSegmentInAString();
//		System.out.println(nos.countSegments("Hello, my name is John"));
//		System.out.println(nos.countSegments("Hello, 	my name is  John "));
		System.out.println(nos.countSegments("                "));
	}
    public int countSegments(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int i = 0, n = s.length(), count = 0;
        boolean preSpace = true;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                if (!preSpace) {
                    count++;
                    preSpace = true;
                }
            } else {
                preSpace = false;
            }
            i++;
        }
        if (!preSpace) {
        	count++;
        }
        return count;
    }
}
