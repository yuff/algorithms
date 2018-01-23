package com.leetcode.mytest;

import java.util.*;

public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		ExcelSheetColumnTitle es = new ExcelSheetColumnTitle();
		System.out.println(es.convertToTitle(7));
		System.out.println(es.convertToTitle(26));
		System.out.println(es.convertToTitle(27));
		System.out.println(es.convertToTitle(53));
		System.out.println(es.convertToTitle(52));
		System.out.println(es.convertToTitle(177));
	}
    public String convertToTitle(int n) {
    	if (n <= 26) {
    		char c = (char)('A' + n - 1);
    		return new String(new char[]{c});
    	}
        List<Character> list = new ArrayList<>();
        while (n > 26) {
        	int tmp = n % 26;
        	n /= 26;
        	if (tmp == 0) {
        		n -= 1;
        	}
        	list.add((char)('A' + (26 + tmp - 1) % 26));
        }
        list.add((char)('A' + n - 1));
        int len = list.size();
        StringBuilder builder = new StringBuilder();
        for(int i = len - 1; i >= 0; i--) {
        	builder.append(list.get(i));
        }
        return builder.toString();
    }
}
