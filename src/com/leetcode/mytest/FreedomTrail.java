package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreedomTrail {
	public static void main(String[] args) {
		FreedomTrail ft = new FreedomTrail();
		System.out.println(ft.findRotateSteps("godding", "gd"));
	}

	public int findRotateSteps(String ring, String key) {
		if (ring == null || ring.isEmpty()) {
			throw new RuntimeException("error input");
		}
		if (key == null || key.isEmpty()) {
			return 0;
		}
		Map<Character, List<Integer>> ringMap = new HashMap<>();
		int n = ring.length();
		for (int i = 0; i < n; i++) {
			char c = ring.charAt(i);
			if (ringMap.get(c) == null) {
				ringMap.put(c, new ArrayList<Integer>());
			}
			ringMap.get(c).add(i);
		}
		int len = key.length();
		@SuppressWarnings("unchecked")
		List<int[]>[] keyStep = new List[len];
		char c = key.charAt(0);
		List<Integer> first = ringMap.get(c);
		List<int[]> list = new ArrayList<>();
		for (int id : first) {
			int[] t = new int[2];
			t[0] = id;
			t[1] = Math.min(id, n - id);
			list.add(t);
		}
		keyStep[0] = list;
		for (int i = 1; i < len; i++) {
			c = key.charAt(i);
			List<Integer> indexs = ringMap.get(c);
			List<int[]> pre = keyStep[i - 1];
			List<int[]> cur = new ArrayList<>();
			for (int id : indexs) {
				int[] t = new int[2];
				t[0] = id;
				t[1] = findMin(pre, id, n);
				cur.add(t);
			}
			keyStep[i] = cur;
		}
		int min = Integer.MAX_VALUE;
		List<int[]> last = keyStep[len - 1];
		for (int[] s : last) {
			if (s[1] < min) {
				min = s[1];
			}
		}
		return min + len;
	}

	private int findMin(List<int[]> pre, int id, int n) {
		int min = Integer.MAX_VALUE;
		for (int[] s : pre) {
			int preId = s[0];
			int one = Math.abs(id - preId);
			int two = Math.min(id, preId) + n - Math.max(id, preId);
			int t = s[1] + Math.min(one, two);
			if (t < min) {
				min = t;
			}
		}
		return min;
	}
}
