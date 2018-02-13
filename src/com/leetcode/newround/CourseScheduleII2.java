package com.leetcode.newround;

import java.util.*;

import com.java8.util.CommonUtil;

public class CourseScheduleII2 {
	public static void main(String[] args) {
		CourseScheduleII2 cs = new CourseScheduleII2();
		int[][] prerequisites = new int[4][2];
		prerequisites[0] = new int[] {1, 0};
		prerequisites[1] = new int[] {2, 1};
		prerequisites[2] = new int[] {3, 1};
		prerequisites[3] = new int[] {3, 2};
		int[] result = cs.findOrder(4, prerequisites);
		CommonUtil.print(result);
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0) {
			return new int[0];
		}
		int[] result = new int[numCourses];
		Map<Integer, List<Integer>> preMap = new HashMap<>();
		Map<Integer, List<Integer>> followMap = new HashMap<>();
		buildFollowMap(prerequisites, preMap, followMap);
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!preMap.containsKey(i) || preMap.get(i) == null || preMap.get(i).isEmpty()) {
				stack.push(i);
				preMap.remove(i);
			}
		}
		int i = 0;
		while (!stack.isEmpty()) {
			int top = stack.pop();
			result[i++] = top;
			List<Integer> posts = followMap.getOrDefault(top, new ArrayList<>());
			for (int post : posts) {
				preMap.get(post).remove(Integer.valueOf(top));
				if (preMap.get(post).size() == 0) {
					stack.push(post);
					preMap.remove(post);
				}
			}
		}
		if (i < numCourses) {
			return new int[0];
		}
		return result;
	}

	private void buildFollowMap(int[][] prerequisites, Map<Integer, List<Integer>> preMap,
	                            Map<Integer, List<Integer>> followMap) {
		int n = prerequisites.length;
		for(int i = 0; i < n; i++) {
			int pre = prerequisites[i][0], post = prerequisites[i][1];
			List<Integer> preList = preMap.getOrDefault(pre, new ArrayList<>());
			preList.add(post);
			preMap.put(pre, preList);
			List<Integer> followList = followMap.getOrDefault(post, new ArrayList<>());
			followList.add(pre);
			followMap.put(post, followList);
		}

	}

}
