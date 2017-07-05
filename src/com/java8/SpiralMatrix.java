package com.java8;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
//		String[] sArray = new String[4];
//		System.out.println(sArray[0]);
//		System.out.println(3 & 1);

		List<Integer> list = new ArrayList<>();
		int[] nums = new int[] {1, 2, 3, 4, 7};
		for (int num : nums) {
			list.add(num);
		}
		System.out.println(list.size());
		int result = changeList(list);
		System.out.println(result);
		System.out.println(list.size());
	}

	public static int changeList(List<Integer> list) {
		return list.remove(0);
	}
}
