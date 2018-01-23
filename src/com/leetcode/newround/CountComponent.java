package com.leetcode.newround;

import java.util.*;

/**
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of
 * nodes), write a function to find the number of connected components in an undirected graph.
 * Example 1:      0 3      | |      1 --- 2 4 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]],
 * return 2. Example 2:      0 4      | |      1 --- 2 --- 3 Given n = 5 and edges = [[0, 1], [1,
 * 2], [2, 3], [3, 4]], return 1. Note: You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together
 * in edges.
 *
 */
public class CountComponent {
	public static void main(String[] args) {
		CountComponent cc = new CountComponent();
		int[][] edges = new int[3][2];
		edges[1] = new int[]{1,2};
		edges[2] = new int[]{3,1};
		edges[0] = new int[]{3,2};
		System.out.println(cc.countComponents(4, edges ));
	}
	public int countComponents(int n, int[][] edges) {
		if (n == 0 || edges == null || edges.length == 0) {
			return 0;
		}
		boolean[] visit = new boolean[n];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			Set<Integer> set0 = map.getOrDefault(edge[0], new HashSet<>());
			set0.add(edge[1]);
			map.put(edge[0], set0);
			Set<Integer> set1 = map.getOrDefault(edge[1], new HashSet<>());
			set1.add(edge[0]);
			map.put(edge[1], set1);
		}
		int count = 0, i = 0;
		while (i < n) {
			if (!visit[i]) {
				LinkedList<Integer> stack = new LinkedList<>();
				stack.push(i);
				while (!stack.isEmpty()) {
					int id = stack.pop();
					if (visit[id]) {
						continue;
					}
					Set<Integer> set = map.get(id);
					if (set != null) {						
						for (int num : set) {
							stack.push(num);
						}
					}
					visit[id] = true;
				}
				count++;
			}
			i++;
		}
		return count;
	}
}
