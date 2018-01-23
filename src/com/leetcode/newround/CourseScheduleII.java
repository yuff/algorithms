package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class CourseScheduleII {
	public static void main(String[] args) {
		CourseScheduleII cs = new CourseScheduleII();
		int[][] prerequisites = new int[4][2];
		prerequisites[0] = new int[] {1, 0};
		prerequisites[1] = new int[] {2, 1};
		prerequisites[2] = new int[] {3, 1};
		prerequisites[3] = new int[] {3, 2};
		int[] result = cs.findOrder(4, prerequisites);
		CommonUtil.print(result);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		if (numCourses == 0) {
			return result;
		}
		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				result[i] = i;
			}
			return result;
		}
		int[][] time = new int[numCourses][3];
		boolean[] visit = new boolean[numCourses];
		LinkedList<Integer> stack = new LinkedList<>();
		Map<Integer, List<Integer>> map = buildEdges(prerequisites);
		int curTime = 0;
		for (int i = 0; i < numCourses; i++) {
			time[i][0] = i;
			if (!visit[i]) {
				stack.push(i);
				while (!stack.isEmpty()) {
					int v = stack.peek();
					if (!visit[v] && map.get(v) != null && map.get(v).size() > 0) {
						time[v][1] = curTime++;
						visit[v] = true;
						boolean canContinue = addEdges(visit, stack, map.get(v));
						if (!canContinue) {
							return new int[0];
						}
					}
					else {
						stack.pop();
						visit[v] = true;
						time[v][2] = curTime++;
					}
				}
			}
		}
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < numCourses; i++) {
			result[i] = time[i][0];
		}
		return result;
	}

	private boolean addEdges(boolean[] visit, LinkedList<Integer> stack, List<Integer> list) {
		for (int i : list) {
			if (stack.contains(i)) {
				return false;
			}
			else {
				if (!visit[i]) {
					stack.push(i);					
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
