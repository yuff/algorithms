package com.java8.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

class Element {
	private String ident;

	public Element(String id) {
		ident = id;
	}

	public String toString() {
		return ident;
	}

	public int hashCode() {
		return ident.hashCode();
	}

	public boolean equals(Object r) {
		return r instanceof Element && ident.equals(((Element) r).ident);
	}

	protected void finalize() {
		System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
	}
}

class Key extends Element {
	public Key(String id) {
		super(id);
	}
}

class Value extends Element {
	public Value(String id) {
		super(id);
	}
}

public class CanonicalMapping {
	public static void main(String[] args) {
		int size = 10;
		List<Key> keys = new ArrayList<>();
		WeakHashMap<Key,Value> map = new WeakHashMap<>();
		for(int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
			if (i % 3 == 0) {
				keys.add(k);
			}
			map.put(k, v);	
		}
		System.gc();
		System.out.println(keys);
//		System.gc();
	}
}
