package com.leetcode.mytest;

import java.util.*;

public class MinimunHeightTrees {
	public static void main(String[] args) {
		MinimunHeightTrees mh = new MinimunHeightTrees();
		int[][] edges = new int[6][2];
		edges[0] = new int[] {0, 1};
		edges[1] = new int[] {1, 2};
		edges[2] = new int[] {1, 3};
		edges[3] = new int[] {2, 4};
		edges[4] = new int[] {3, 5};
		edges[5] = new int[] {4, 6};

		int[][] edges1 = new int[3][2];
		edges1[0] = new int[] {1, 0};
		edges1[1] = new int[] {1, 2};
		edges1[2] = new int[] {1, 3};

		System.out.println(mh.findMinHeightTrees(7, edges));
		 System.out.println(mh.findMinHeightTrees(4, edges1));
		 System.out.println(mh.findMinHeightTrees(1, new int[][] {}));
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		if (n <= 0) {
			return result;
		}
		if (n == 1) {
			result.add(0);
			return result;
		}
		Map<Integer, Set<Integer>> map = new HashMap<>();
		countEdges(edges, map);
		Set<Integer> starts = getStartVerticals(map);

		while (starts.size() > 0) {
			Set<Integer> tmp = new HashSet<>();
			for (int v : starts) {
				Iterator<Integer> it = map.get(v).iterator();
				if (it.hasNext()) {
					int id = it.next();
					map.get(id).remove(v);
					if (map.get(id).size() == 1) {
						tmp.add(id);
					}
				}
			}
			if (tmp.size() == 0) {
				result.addAll(starts);
			}
			starts = tmp;
		}
		return result;
	}

	private Set<Integer> getStartVerticals(Map<Integer, Set<Integer>> map) {
		Set<Integer> result = new HashSet<>();
		for (int i : map.keySet()) {
			if (map.get(i).size() == 1) {
				result.add(i);
			}
		}
		return result;
	}

	private void countEdges(int[][] edges, Map<Integer, Set<Integer>> map) {
		int n = edges.length;
		for (int i = 0; i < n; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			if (map.get(v1) == null) {
				map.put(v1, new HashSet<>());
			}
			if (map.get(v2) == null) {
				map.put(v2, new HashSet<>());
			}
			map.get(v1).add(v2);
			map.get(v2).add(v1);
		}
	}
}
