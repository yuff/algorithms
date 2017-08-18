package com.java8.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfiniteRecursion {

	@Override
	public String toString() {
		return " InfiniteRecursion address: " + super.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(new InfiniteRecursion());
//		System.out.printf("Row 1: [%d %f]", 1, 1.0);
		List<InfiniteRecursion> list = new ArrayList<>();
		for(int i = 0; i < 2; i++) {
			list.add(new InfiniteRecursion());
		}
		System.out.println(list);
		Iterator<InfiniteRecursion> it = list.iterator();
		while(it.hasNext()) {
			it.next();
			it.remove();
			System.out.println(list);
		}
	}
}
