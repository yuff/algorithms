package com.java8.generic;

public class Holder<T> {
	private T value;
	public Holder() {
		
	}
	public Holder(T value) {
		this.value = value;
	}
	public void set(T val) {
		this.value = val;
	}
	public T get() {
		return value;
	}
	public boolean equals(Object obj) {
		return value.equals(obj);
	}
}
