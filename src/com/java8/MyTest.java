package com.java8;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.junit.Test;

import com.java8.util.TreeNode;

public class MyTest {

	List<TreeNode> list = new ArrayList<>();

	@Test
	public void testGeneric() {
		try {
			com.java8.Test.class.newInstance();
			MyTest myTest = new MyTest();
			Class<?> clazz = myTest.getClass();
			Field f = clazz.getDeclaredField("list");
			List<Integer> iList = new ArrayList<>();
			iList.add(1);
			f.set(myTest, iList);
			System.out.println(myTest.list);
			
			List tmp = (List) f.get(myTest);
			tmp.add("abcd");
			tmp.add(1234);
			tmp.add(new TreeNode(4));
			System.out.println(myTest.list);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testStringSplit() {
		String s = "-1/2+1/3-1/4";
		String[] strs = s.split("\\+|\\-");
		String[] syms = s.split("[0-9]+/[0-9]+");
		System.out.println(strs.length);
		System.out.println(syms.length);
		System.out.println(syms[0]);
	}
	
	@Test
	public void testScanner() {
		List<Integer>[] a = new List[26];
		Scanner sc = new Scanner("-1/2+1/3-1/4").useDelimiter("/|(?=[-+])");
		while(sc.hasNext()) {
			System.out.println(sc.nextInt());
			System.out.println(sc.nextInt());
			System.out.println("---");
		}		
	}

	@Test
	public void testMath() {
		double value = 100 * Math.log(10) * 4 / 10;
		System.out.println(value);
		System.out.println(2%(-4));
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

	@Test
	public void testSortString() {
		List<String> list = new ArrayList<>();
		list.add("ab");
		list.add("abc");
		list.add("abcd");
		list.add("bem");
		list.add("bde");
		list.add("cam");
		list.add("ehj");
		Collections.sort(list);
		System.out.println(list);
	}

	@Test
	public void testPriorityQueue() {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(2);
		list.add(5);
		list.add(6);
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		queue.addAll(list);
		while (!queue.isEmpty()) {
			System.out.print(queue.poll());
			System.out.print(",");
		}
	}
	
	@Test
	public void testForEach() {
		List<String> list = new ArrayList<>();
		list.add("first");
		list.add("second");
		for(String s: list) {
			
		}
	}
}
