package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HappyNumber {
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(20));
	}
	public boolean isHappy(int n) {
		if (n == 0) {
			return false;
		}
		else if (n == 1) {
			return true;
		}
		Map<String, Boolean> map = new HashMap<>();
		while (n != 1) {
			String str = getStr(n);
			if (map.get(str) != null) {
				return false;
			}
			else {
				map.put(str, true);
				n = cal(str);
			}
		}
		return true;
	}

	private int cal(String str) {
		int len = str.length();
		int result = 0;
		for (int i = 0; i < len; i++) {
			int v = str.charAt(i) - '0';
			result += v * v;
		}
		return result;
	}

	private String getStr(int n) {
		List<Character> cList = new ArrayList<>();
		while (n > 0) {
			char c = (char) ((n % 10) + '0');
			cList.add(c);
			n = n / 10;
		}
		Collections.sort(cList);
		StringBuilder b = new StringBuilder();
		for (char c : cList) {
			b.append(c);
		}
		return b.toString();
	}
}
