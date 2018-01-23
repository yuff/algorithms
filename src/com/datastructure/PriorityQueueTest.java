package com.datastructure;

import java.util.*;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Map<Integer,List<Integer>> map = new HashMap<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		map.put(1, list1 );
		map.put(2, list2);
		PriorityQueue<Map.Entry<Integer, List<Integer>>> queue  = new PriorityQueue<>(new Comparator<Map.Entry<Integer,List<Integer>>>() {
			@Override
			public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
				return o1.getValue().size() - o2.getValue().size();
			}
		});
		queue.addAll(map.entrySet());
		System.out.println(queue);
		map.get(2).clear();
		System.out.println(queue);
		map.remove(queue.poll().getKey());
		System.out.println(queue);
		
	}
}
