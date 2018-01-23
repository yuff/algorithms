package com.leetcode.mytest;

import java.util.*;

public class AllOne_1 {
	public static void main(String[] args) {
		AllOne_1 ao = new AllOne_1();
		ao.inc("abc");
		ao.inc("Hello");
		ao.inc("Hello");
		ao.inc("Hello");
		ao.inc("Hello");
		ao.dec("Hello");
		ao.dec("Hello");
		System.out.println(ao.getMaxKey());
		System.out.println(ao.getMinKey());
		ao.dec("abc");
		ao.dec("Hello");
		ao.inc("new");
		ao.inc("new");
		ao.inc("abc");
		ao.inc("abc");
		ao.inc("abc");
		System.out.println(ao.getMaxKey());
		System.out.println(ao.getMinKey());
	}

	Map<String, Node> map = new HashMap<>();
	List<Node> list = new ArrayList<>();
	Map<Integer, Range> idMap = new HashMap<>();
	int size = 0;

	/** Initialize your data structure here. */
	public AllOne_1() {

	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		if (map.get(key) == null) {
			Node node = new Node(key, size);
			map.put(key, node);
			list.add(size, node);
			if (idMap.get(1) == null) {
				idMap.put(1, new Range(size, size));
			}
			else {
				Range oneRange = idMap.get(1);
				oneRange.end += 1;
			}
			size++;
		}
		else {
			Node node = map.get(key);
			int preValue = node.value;
			node.value += 1;
			int preValueStartId = idMap.get(preValue).start;
			if (node.id == preValueStartId && idMap.get(preValue).end == preValueStartId) {
				idMap.remove(preValue);
			}
			else {
				swap(list, map, node.id, preValueStartId);
				// update pre value range
				Range preValueRange = idMap.get(preValue);
				preValueRange.start += 1;
			}
			node = map.get(key);
			// update new value end range
			if (idMap.get(node.value) == null) {
				idMap.put(node.value, new Range(node.id, node.id));
			}
			else {
				Range preRange = idMap.get(node.value);
				preRange.end += 1;
			}
		}
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if (map.get(key) == null) {
			return;
		}
		else {
			Node node = map.get(key);
			if (node.value == 1) {
				node.value -= 1;
				swap(list, map, node.id, size - 1);
				map.remove(key);
				size--;
			}
			else {
				int preValue = node.value;
				node.value -= 1;
				int preValueEndId = idMap.get(preValue).end;
				if (preValueEndId == node.id && idMap.get(preValue).start == preValueEndId) {
					idMap.remove(preValue);
				}
				else {
					swap(list, map, node.id, preValueEndId);
					// update pre value range
					Range preValueRange = idMap.get(preValue);
					preValueRange.end -= 1;
				}
				node = map.get(key);
				// update new value end range
				if (idMap.get(node.value) == null) {
					idMap.put(node.value, new Range(node.id, node.id));
				}
				else {
					Range preRange = idMap.get(node.value);
					preRange.start -= 1;
				}
			}
		}
	}

	private void swap(List<Node> list, Map<String, Node> map, int preId, int newId) {
		if (preId == newId) {
			return;
		}
		Node preNode = list.get(preId);
		Node newNode = list.get(newId);

		int preValue = preNode.value;
		int newValue = newNode.value;

		String preKey = preNode.key;
		String newKey = newNode.key;

		preNode.key = newKey;
		preNode.value = newValue;

		newNode.key = preKey;
		newNode.value = preValue;

		map.put(preKey, newNode);
		map.put(newKey, preNode);
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return size == 0 ? "" : list.get(0).key;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return size == 0 ? "" : list.get(size - 1).key;
	}
}

class Node {
	Node(String key, int size) {
		this.key = key;
		this.value = 1;
		this.id = size;
	}

	String key;
	int value;
	int id;
}

class Range {
	Range(int start, int end) {
		this.start = start;
		this.end = end;
	}

	int start;
	int end;
}
