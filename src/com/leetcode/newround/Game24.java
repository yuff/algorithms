package com.leetcode.newround;

import java.util.*;

public class Game24 {
	public static void main(String[] args) {
		Game24 g = new Game24();
//		System.out.println(g.judgePoint24(new int[] {4, 1, 8, 7}));
//		System.out.println(g.judgePoint24(new int[] {1, 4, 8, 7}));
		System.out.println(g.judgePoint24(new int[] {3, 3, 8, 8}));
	}

	public boolean judgePoint24(int[] nums) {
		if (nums == null || nums.length != 4) {
			return false;
		}
		int n = 4;
		List<Double> init = new ArrayList<>();
		for (int num : nums) {
			init.add((double) num);
		}
		List<List<Double>> result = new ArrayList<>();
		result.add(init);
		while (n > 1) {
			List<List<Double>> mid = new ArrayList<>();
			for (List<Double> list : result) {
				mid.addAll(reduction(list, n));
			}
			n--;
			result = mid;
		}
		System.out.println(result);
		for (List<Double> list : result) {
			if (Math.abs(list.get(0) - 24) < 0.001) {
				return true;
			}
		}
		return false;
	}

	private List<List<Double>> reduction(List<Double> origin, int n) {
		List<List<Double>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			double first = origin.get(i);
			for (int j = i + 1; j < n; j++) {
				List<Double> remain = new ArrayList<>(origin);
				remain.remove(origin.get(i));
				remain.remove(origin.get(j));

				double second = origin.get(j);
				Set<Double> set = calculate(first, second);
				for (double d : set) {
					List<Double> tmp = new ArrayList<>();
					tmp.add(d);
					tmp.addAll(remain);
					result.add(tmp);
				}
			}
		}
		return result;
	}

	private Set<Double> calculate(double first, double second) {
		Set<Double> result = new HashSet<>();
		result.add(first + second);
		result.add(first - second);
		result.add(first * second);
		if (second != 0.0) {			
			result.add(first / second);
		}
		result.add(second - first);
		if (first != 0.0) {			
			result.add(second / first);
		}
		return result;
	}
}
