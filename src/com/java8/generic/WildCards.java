package com.java8.generic;

public class WildCards {

	static void rawArgs(Holder holder, Object arg) {
		Object obj = holder.get();
		holder.set(arg);
		System.out.println("rawArgs:" + holder + "," + obj + ", " + holder.get());
	}

	static void unboundedArg(Holder<?> holder, Object obj) {
		// holder.set(obj);
		Object o = holder.get();
		System.out.println("unboundedArg:" + holder + "," + o);
	}

	static <T> T exact1(Holder<T> holder) {
		return holder.get();
	}

	static <T> T exact2(Holder<T> holder, T arg) {
		holder.set(arg);
		return holder.get();
	}

	static <T> T wildSubType(Holder<? extends T> holder, T arg) {
		// holder.set(arg);//error
		return holder.get();
	}

	static <T> T wildSuperType(Holder<? super T> holder, T arg) {
		holder.set(arg);
		T obj = (T) holder.get();
		return obj;
	}

	public static void main(String[] args) {
		Holder raw = new Holder<Long>();
		Holder<Long> qualified = new Holder<>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<>();
		Holder<? super Long> superBound = new Holder<>();
		Long lng = 1L;
		rawArgs(raw, lng);
		rawArgs(qualified, lng);
		rawArgs(unbounded, lng);
		rawArgs(bounded, lng);
		rawArgs(superBound, lng);

		unboundedArg(raw, lng);
		unboundedArg(qualified, lng);
		unboundedArg(unbounded, lng);
		unboundedArg(bounded, lng);
		unboundedArg(superBound, lng);

		Object r1 = exact1(raw);
		System.out.println(r1);
		Long q1 = exact1(qualified);
		// String u1 = (String)exact1(unbounded); //java.lang.ClassCastException: java.lang.Long
		// cannot be cast to java.lang.String
		Long b1 = exact1(bounded);

		Object r2 = exact2(raw, "abc");
		Object r21 = exact2(raw, 111L);
		System.out.println(r2);
		System.out.println(r21);

//		Object u2 = exact2(unbounded, "111");// compiler error
		
		Object u2 = exact2(superBound, 666L);
		System.out.println(u2);
		
		Object r3 = wildSubType(raw, "test");
		System.out.println(r3);
		Long r31 = wildSubType(raw, 888L);
		System.out.println(r3);
		
		Long q3 = wildSubType(qualified, lng);
		
		Object u3 = wildSubType(unbounded, lng);
		Long b3 = wildSubType(bounded, lng);
		Object s3 = wildSubType(superBound, lng);
		
		String r4 = wildSuperType(raw, "ABC");
		Long r41 = wildSuperType(raw, 123L);
		
		Long q4 = wildSuperType(qualified, lng);
		
		Object u4 = wildSubType(unbounded, lng);
//		Long b4 = wildSuperType(bounded, lng); //error
		Object s4 = wildSuperType(superBound, lng);
	}
}
