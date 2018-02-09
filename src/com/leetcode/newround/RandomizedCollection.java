package com.leetcode.newround;

import java.util.*;

public class RandomizedCollection {
	public static void main(String[] args) {
		RandomizedCollection rc = new RandomizedCollection();
		System.out.println(rc.insert(1));
		System.out.println(rc.insert(1));
		System.out.println(rc.insert(2));
		System.out.println(rc.insert(2));
		System.out.println(rc.insert(2));
		System.out.println(rc.remove(1));
		System.out.println(rc.remove(1));
		System.out.println(rc.remove(2));
		System.out.println(rc.insert(1));
		System.out.println(rc.remove(2));
	}
	Map<Integer, List<Integer>> map = new HashMap<>();
	List<Integer> list = new ArrayList<>();
	Random rand = new Random();

	/** Initialize your data structure here. */
	public RandomizedCollection() {

	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not already contain the
	 * specified element.
	 */
	public boolean insert(int val) {
		boolean flag = false;
		if (!map.containsKey(val)) {
			map.put(val, new ArrayList<>());
			flag = true;
		}
		map.get(val).add(list.size());
		list.add(val);
		return flag;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		boolean flag = map.containsKey(val);
		if (flag) {
			List<Integer> ids = map.get(val);
			int idx = ids.get(ids.size() - 1);
			int lastOne = list.get(list.size() - 1);
			List<Integer> lastOneIds = map.get(lastOne);
			lastOneIds.remove(Integer.valueOf(list.size() - 1));
			list.set(idx, lastOne);
			lastOneIds.add(idx);
//			Collections.sort(lastOneIds);
			ids.remove(ids.size() - 1);
			if (ids.size() == 0) {
				map.remove(val);
			}
			list.remove(list.size() - 1);
		}
		return flag;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}
}
