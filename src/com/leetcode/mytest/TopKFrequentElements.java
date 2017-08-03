package com.leetcode.mytest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public static void main(String[] args) {
		TopKFrequentElements tke = new TopKFrequentElements();
		int[] nums = new int[] {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5};
		List<Integer> r = tke.topKFrequent(nums, 4);
		System.out.println(tke.topKFrequent(nums, 4));
		System.out.println(tke.topKFrequent_1(nums, 4));
	}

	public List<Integer> topKFrequent_1(int[] nums, int k) {
		Map<Integer, Integer> counterMap = new HashMap<>();
		for (int num : nums) {
			int count = counterMap.getOrDefault(num, 0);
			counterMap.put(num, count + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k) pq.poll();
		}

		List<Integer> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(0, pq.poll().getKey());
		}
		return res;
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.get(i) == null) {
				map.put(i, 1);
			}
			else {
				map.put(i, map.get(i) + 1);
			}
		}
//		PriorityQueue<Map.Entry<Integer, Integer>> queue =
//		                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
//			                @Override
//			                public int compare(Map.Entry<Integer, Integer> v1, Map.Entry<Integer, Integer> v2) {
//				                return v2.getValue() - v1.getValue();
//			                }
//		                });
		PriorityQueue<Map.Entry<Integer, Integer>> queue =
		                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
			                @Override
			                public int compare(Map.Entry<Integer, Integer> v1, Map.Entry<Integer, Integer> v2) {
				                return v2.getValue() - v1.getValue();
			                }
		                });
		queue.addAll(map.entrySet());
		List<Integer> result = new ArrayList<>();
		while (k > 0) {
			result.add(queue.poll().getKey());
			k--;
		}
		return result;
	}
}
