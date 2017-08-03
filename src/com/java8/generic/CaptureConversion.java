package com.java8.generic;

import java.util.List;

public class CaptureConversion {
	static <T> void f1(Holder<T> holder) {
		T t = holder.get();
		System.out.println(t.getClass().getSimpleName());
	}
	static void f2(Holder<?> holder) {
		f1(holder);
	}
	
	static void f3(Holder<List<?>> holder) {
//		holder.get().add(1);//compile error
		holder.get().get(0);
//		holder.set(new ArrayList<Integer>()); // compile error
	}
	
	public static void main(String[] args) {
		Holder raw = new Holder(1);
		f1(raw);
		f2(raw);
		
		Holder rawBasic = new Holder();
		rawBasic.set("123");
		f1(rawBasic);
		f2(rawBasic);
		
		Holder<?> wild = new Holder<>(2.0);
		f1(wild);
		f2(wild);
	}
}
