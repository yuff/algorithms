package com.java8.collection;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(16, 0.75f, true);
		linkedMap.put(0, "A0");
		linkedMap.put(1, "B1");
		linkedMap.put(2, "C2");
		linkedMap.put(3, "D3");
		linkedMap.put(4, "E4");
		System.out.println(linkedMap);
		for(int i = 0; i < linkedMap.size(); i++) {
			linkedMap.get(i);
		}
		System.out.println(linkedMap);
		linkedMap.get(3);
		linkedMap.get(0);
		System.out.println(linkedMap);
	}
}
