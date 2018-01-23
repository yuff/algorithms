package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.List;

import com.java8.util.CommonUtil;

public class StringCompression {
	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		char[] chars2 = new char[]{'a','a','b','b','c','c','c'};
		System.out.println(sc.compress(chars));
		System.out.println(sc.compress(chars2));
		CommonUtil.print(chars);
		CommonUtil.print(chars2);
		
	}
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
        	return 0;
        }
        int start = 0, count = 1, n = chars.length;
        char cur, pre = chars[0];
        for(int i = 1; i < n; i++) {
        	cur = chars[i];
        	if (cur == pre) {
        		count++;
        	} else {
        		start = fillPreCur(chars, start, pre, count);
        		pre = cur;
        		count = 1;
        	}
        }
        return fillPreCur(chars, start, pre, count);
    }

	private int fillPreCur(char[] chars, int start, char pre, int count) {
		chars[start++] = pre;
		if (count == 1) {
			return start;
		}
		char[] list = String.valueOf(count).toCharArray();
		for(int i = 0; i < list.length; i++) {
			chars[start++] = list[i];
		}
		return start;
	}

	private List<Character> convertToChar(int count) {
		List<Character> list = new ArrayList<>();
		while (count > 0) {
			int t = count % 10;
			list.add((char)(t + '0'));
			count /= 10;
		}
		return list;
	}
}
