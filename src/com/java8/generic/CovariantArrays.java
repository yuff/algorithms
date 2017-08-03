package com.java8.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

public class CovariantArrays {

	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new Jonathan());
		// apples.add(new Fruit());

	}

	public static void main(String[] args) {
		List<? super Apple> foo0 = new ArrayList<Fruit>();
		foo0.add(new Apple());
		foo0.add(new Jonathan());
		// foo0.add(new Fruit());//error
		List<? extends Fruit> foo1 = new ArrayList<Apple>();
		// foo1.add(new Apple()); // error
		List<? extends Fruit> flist =
		                Arrays.asList(new Fruit[] {new Apple(), new Orange(), new Fruit(), new Jonathan()});
		System.out.println(flist);
		System.out.println((Apple) flist.get(0));
		System.out.println((Fruit) flist.get(1));
		System.out.println((Apple) flist.get(3));
		System.out.println((Apple) flist.get(1));
	}
}
