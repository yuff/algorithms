package com.java8.generic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {

	private Class<T> kind;
	public ArrayMaker(Class<T> kind) {
		this.kind = kind;
		Object obj;
	}
	@SuppressWarnings("unchecked")
	T[] create(int size) {
		return (T[]) Array.newInstance(kind, size);
	}
	
	public static void main(String[] args) {
		ArrayMaker<Integer> stringMaker = new ArrayMaker<Integer>(Integer.class);
		Integer[] stringArray = stringMaker.create(9);
		System.out.println(Arrays.toString(stringArray));
	}
}
