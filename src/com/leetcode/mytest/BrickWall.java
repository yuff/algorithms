package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class BrickWall {
	public static void main(String[] args) {
		BrickWall bw = new BrickWall();
		List<List<Integer>> wall = new ArrayList<>();
		int[] i1 = new int[] {1, 2, 2, 1};
		int[] i2 = new int[] {3, 1, 2};
		int[] i3 = new int[] {1, 3, 2};
		int[] i4 = new int[] {2, 4};
		int[] i5 = new int[] {3, 1, 2};
		int[] i6 = new int[] {1, 3, 1, 1};
		List<Integer> l1 = new ArrayList<>();
		for(int i: i1) {
			l1.add(i);
		}
		wall.add(l1);
		List<Integer> l2 = new ArrayList<>();
		for(int i: i2) {
			l2.add(i);
		}
		wall.add(l2);
		List<Integer> l3 = new ArrayList<>();
		for(int i: i3) {
			l3.add(i);
		}
		wall.add(l3);
		List<Integer> l4 = new ArrayList<>();
		for(int i: i4) {
			l4.add(i);
		}
		wall.add(l4);
		List<Integer> l5 = new ArrayList<>();
		for(int i: i5) {
			l5.add(i);
		}
		wall.add(l5);
		List<Integer> l6 = new ArrayList<>();
		for(int i: i6) {
			l6.add(i);
		}
		wall.add(l6);
		System.out.println(bw.leastBricks(wall));
	}

	public int leastBricks(List<List<Integer>> wall) {
		if (wall == null || wall.isEmpty()) {
			return 0;
		}
		int n = wall.size();
		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> list : wall) {
			int sum = 0;
			int len = list.size();
			for (int i = 0; i < len - 1; i++) {
				sum += list.get(i);
				if (map.get(sum) == null) {
					map.put(sum, 1);
				}
				else {
					map.put(sum, map.get(sum) + 1);
				}
			}
		}
		if (map.entrySet() == null || map.entrySet().isEmpty()) {
			return n;
		}
		PriorityQueue<Map.Entry<Integer, Integer>> queue =
		                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
			                @Override
			                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				                return o2.getValue() - o1.getValue();
			                }
		                });
		queue.addAll(map.entrySet());
		Map.Entry<Integer, Integer> me = queue.poll();
		return n - me.getValue();
	}
}
