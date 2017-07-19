package com.java8;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyTest {

	@Test
	public void testMath() {
		double value = 100 * Math.log(10)* 4 / 10;
		System.out.println(value);
	}
	
	@Test
	public void testList() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.clear();
		list.add(20);
		System.out.println(list.size());
		int[] a = list.stream().mapToInt(i -> i).toArray();
		System.out.println(a);
	}
}
