package com.multithread.lock;

public class Counter {

	/**
	 * !!NOTE:static method addStatic and instance method add can both modify count, even though
	 * there is synchronized, still not thread safe
	 */
	private int count = 0;

	private static int staticIterator = 0;

	synchronized public static void addStatic() {
		int tmp = staticIterator;
		System.out.println(Thread.currentThread() + "--before add static: " + tmp);

		staticIterator++;
		tmp = staticIterator;

		System.out.println(Thread.currentThread() + "--after add static: " + tmp);
	}

	synchronized public void add() {
		System.out.println(Thread.currentThread() + "--before add: " + count);
		count++;
		System.out.println(Thread.currentThread() + "--after add: " + count);
	}

	public static void addStaticBlock() {
		int tmp = staticIterator;
		System.out.println(Thread.currentThread() + "--before add static: " + tmp);
		synchronized (Counter.class) {
			staticIterator++;
			tmp = staticIterator;
		}
		System.out.println(Thread.currentThread() + "--after add static: " + tmp);
	}

	public void addBlock() {
		synchronized (System.out) {
			System.out.println(Thread.currentThread() + "--before add block: " + count);
			count++;
			System.out.println(Thread.currentThread() + "--after add block: " + count);
		}
	}
}
