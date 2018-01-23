package com.leetcode.mytest;

import java.util.*;

public class RedundantConnection {
	public static void main(String[] args) {
		RedundantConnection rc = new RedundantConnection();
		int[][] edges = new int[5][2];
		edges[0] = new int[]{3,4};
		edges[1] = new int[]{1,2};
		edges[2] = new int[]{2,4};
		edges[3] = new int[]{3,5};
		edges[4] = new int[]{2,5};
		int[] result = rc.findRedundantConnection(edges );
		System.out.println(result[0] + "," + result[1]);
	}
	public int[] findRedundantConnection(int[][] edges) {
		if (edges == null || edges.length == 0 || edges[0].length != 2) {
			return new int[0];
		}
		Map<Integer, Set<Integer>> map = new HashMap<>();
		int[] result = new int[2];
		for (int[] edge : edges) {
			if (map.get(edge[0]) == null) {
				map.put(edge[0], new HashSet<>());
			}
			if (map.get(edge[1]) == null) {
				map.put(edge[1], new HashSet<>());
			}
			if (!checkIfCycleExist(map, edge[0], edge[1])) {
				map.get(edge[0]).add(edge[1]);
				map.get(edge[1]).add(edge[0]);
			}
			else {
				result = edge;
				break;
			}
		}
		return result;
	}

	private boolean checkIfCycleExist(Map<Integer, Set<Integer>> map, int a, int b) {
		if (map.get(a) == null || map.get(a).size() == 0 || map.get(b) == null || map.get(b).size() == 0) {
			return false;
		}
		Set<Integer> set = getAllConnects(map, a, new ArrayList<Integer>());
		return set.contains(b);
	}

	private Set<Integer> getAllConnects(Map<Integer, Set<Integer>> map, int a, List<Integer> process) {
		Set<Integer> result = new HashSet<>();
		if (!process.contains(a)) {
			Set<Integer> set = map.get(a);
			result.addAll(set);
			process.add(a);
			for (int i : set) {
				result.addAll(getAllConnects(map, i, process));
			}
		}
		return result;
	}
}
