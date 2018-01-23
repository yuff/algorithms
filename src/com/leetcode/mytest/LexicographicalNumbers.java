package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {
	public static void main(String[] args) {
		LexicographicalNumbers ln = new LexicographicalNumbers();
		System.out.println(ln.lexicalOrder(49999));
	}
	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return String.valueOf(o1).compareTo(String.valueOf(o2));
			}

		});
		return list;
	}
}
