package com.java8;

import java.util.*;

public class SubTest extends Sup{
	static {
//		System.out.println(B);//Cannot reference a field before it is defined
	}
	public static String B = "def";
	
	public static void main(String[] args) {
		System.out.println(SubTest.A);
		Map<Integer,Integer> map = new HashMap<>();
		map.put(null, null);
		System.out.println(map);
	}
}
