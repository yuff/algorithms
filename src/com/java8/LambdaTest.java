package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

public class LambdaTest {
	static int count = 0;
	@Test
	public void test() {
		Integer[] array = {1,23,43,12,3,5,39};
		LambdaTest.testLambda(Arrays.asList(array) , 10);
	}
	
	@Test
	public void testMethodRef() {
		Supplier<Num> n1 = () -> new Num();
//		Supplier<Num> n1 = () -> {return new Num();};
//		Supplier<Num> n1 = Num::new;
		Num num = n1.get();
		System.out.println(num.getCount());
	}
	
	public static void testLambda(List<Integer> list, int base) {
		 final int a = base;
		 Num n = new Num();
		 n.setCount(count);
		 list.forEach( num -> {
			 if (num >= base ) {
				 count++;
				 n.add();
				 System.out.println(count + "==" + n.getCount() +"==" + num + " is no small than " + base);
				 System.out.println(a);
			 }
		 });
	}
}

class Num {
	public Num() {
		this.count = -1;
	}
	private int count;	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int add() {
		count++;
		return count;
	}
}
