package com.leetcode.mytest;

import java.lang.reflect.Method;
import java.util.*;

import com.java8.util.CommonUtil;

public class LFUCache {
	public static void main(String[] args) {
		LFUCache lfc = new LFUCache(10);
		String[] operations = new String[] {"put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get",
		                                    "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put",
		                                    "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get",
		                                    "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get",
		                                    "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get",
		                                    "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get",
		                                    "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put",
		                                    "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put",
		                                    "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put",
		                                    "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
		List<int[]> parameters =
		                CommonUtil.buildList("[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]");
		lfc.execute(operations, parameters);
	}

	public void execute(String[] operations, List<int[]> parameters) {
		int n = operations.length;
		for (int i = 0; i < n; i++) {
			try {
				Method method = null;
				if ("get".equals(operations[i])) {
					method = LFUCache.class.getMethod(operations[i], int.class);
					int value = (int) method.invoke(this, parameters.get(i)[0]);
					System.out.print(value + ",");
				}
				else {
					method = LFUCache.class.getMethod(operations[i], int.class, int.class);
					method.invoke(this, parameters.get(i)[0], parameters.get(i)[1]);
				}
			}
			catch (Exception e) {}

		}
	}

	Map<Integer, LFUObject> map;
	PriorityQueue<LFUObject> queue;
	int capacity;

	public LFUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		queue = new PriorityQueue<>(new Comparator<LFUObject>() {
			@Override
			public int compare(LFUObject o1, LFUObject o2) {
				if (o1.freq == o2.freq) {
					return o1.lastVisitTime > o2.lastVisitTime ? 1 : -1;
				}
				else {
					return o1.freq - o2.freq;
				}
			}
		});
	}

	public int get(int key) {
		if (map.get(key) != null) {
			LFUObject obj = map.get(key);
			obj.lastVisitTime = System.nanoTime();
			obj.freq += 1;
			queue.remove(obj);
			queue.add(obj);
			return obj.value;
		}
		else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (capacity <= 0) {
			return;
		}
		if (map.get(key) != null) {
			LFUObject obj = map.get(key);
			obj.value = value;
			obj.lastVisitTime = System.nanoTime();
			map.put(key, obj);
			queue.remove(obj);
			queue.add(obj);
		}
		else {
			if (map.keySet().size() == capacity) {
				map.remove(queue.poll().key);
			}
			LFUObject obj = new LFUObject();
			obj.key = key;
			obj.value = value;
			obj.freq = 0;
			obj.lastVisitTime = System.nanoTime();
			map.put(key, obj);
			queue.add(obj);
		}
	}

}

class LFUObject {
	int key;
	int value;
	int freq;
	long lastVisitTime;
}
