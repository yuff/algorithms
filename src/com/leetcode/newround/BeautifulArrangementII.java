package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class BeautifulArrangementII {
	public static void main(String[] args) {
		BeautifulArrangementII ba = new BeautifulArrangementII();
		CommonUtil.print(ba.constructArray(9, 4));
	}
	public int[] constructArray(int n, int k) {
		int[] result = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		boolean[] visited = new boolean[n + 1];
		constructArray(result, visited, 0, k, map);
		return result;
	}

	private boolean constructArray(int[] result, boolean[] visited, int start, int k, Map<Integer, Integer> map) {
		if (start == result.length) {
			if (map.size() == k) {
				return true;
			}
			else {
				return false;
			}
		}
		for (int i = 1; i <= result.length; i++) {
			if (!visited[i]) {
				if (start > 0 && map.get(Math.abs(result[start - 1] - i)) == null && map.size() == k) {
					return false;
				}
				result[start] = i;
				visited[i] = true;
				int dis = 0;
				if (start > 0) {
					dis = Math.abs(result[start - 1] - i);
					int count = map.getOrDefault(dis, 0);
					map.put(dis, count + 1);
				}
				boolean res = constructArray(result, visited, start + 1, k, map);
				if (res) {
					return true;
				}
				visited[i] = false;
				if (dis > 0) {
					map.put(dis, map.get(dis) - 1);
					if (map.get(dis) == 0) {
						map.remove(dis);
					}
				}
			}
		}
		return false;
	}
}
