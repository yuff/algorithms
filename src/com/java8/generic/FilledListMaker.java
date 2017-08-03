package com.java8.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {

	private Class<T> kind;

	public FilledListMaker() {

	}

	public FilledListMaker(Class<T> kind) {
		this.kind = kind;
	}

	public List<T> create(T t, int n) {
		List<T> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(t);
		}
		return result;
	}

	public void add(List<T> list, T t) {
		if (list.size() == 3) {
			System.out.println(list.get(2).getClass().getSimpleName());
		}
		if (kind != null) {
			if (kind.isInstance(t)) {
				list.add(t);
				System.out.println(this + " list add new element:" + t);
			}
			else {
				System.out.println(this + " " + t.getClass() + " is not instance of " + kind);
				// throw new RuntimeException(t.getClass() + " is not instance of " + kind);
			}
		}
		else {
			list.add(t);
			System.out.println(this + " list add new element:" + t);
		}
	}

	public static void main(String[] args) {
		FilledListMaker<String> maker = new FilledListMaker<>(String.class);
		FilledListMaker<String> maker1 = new FilledListMaker<>();
		List<String> list = maker.create("Hello", 1);
		Class<?> clazz = maker.getClass();
		try {
			Method method = clazz.getDeclaredMethod("add", List.class, Object.class);
			method.invoke(maker, list, "World");
			method.invoke(maker, list, 1);
			method.invoke(maker1, list, 1);
			method.invoke(maker1, list, "maker1");
			System.out.println(list);
			// String s = list.get(3); // java.lang.ClassCastException: java.lang.Integer cannot be
			// cast to java.lang.String
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
