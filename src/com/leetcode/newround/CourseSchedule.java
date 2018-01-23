package com.leetcode.newround;

import java.util.*;

public class CourseSchedule {
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int[][] prerequisites = new int[1][2];
		prerequisites[0] = new int[] {0, 1};
		System.out.println(cs.canFinish(2, prerequisites));
	}

	public boolean canFinish(int n, int[][] prerequisites) {
		if (n == 0) {
			return true;
		}
		int[] stat = new int[n];
		Map<Integer, List<Integer>> map = buildEdges(prerequisites);
		LinkedList<Integer> stack = new LinkedList<>();
		Iterator<Integer> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			int key = iter.next();
			if (stat[key] == 0) {
				stack.push(key);
			}

			while (!stack.isEmpty()) {
				int first = stack.peek();
				if (stat[first] == 1) {
					stack.pop();
					stat[first] = 2;
				}
				else if (stat[first] == 0) {
					List<Integer> verticals = map.get(first);
					if (verticals != null) {
						for (int v : verticals) {
							if (stat[v] == 0) {
								stack.push(v);
							}
							else if (stat[v] == 1) {
								return false;
							}
						}
					}
					stat[first] = 1;
				}
			}
		}
		return true;
	}

	private Map<Integer, List<Integer>> buildEdges(int[][] prerequisites) {
		Map<Integer, List<Integer>> result = new HashMap<>();
		for (int[] pre : prerequisites) {
			List<Integer> list = result.getOrDefault(pre[0], new ArrayList<>());
			list.add(pre[1]);
			result.put(pre[0], list);
		}
		return result;
	}
}
