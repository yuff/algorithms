package com.multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexCounter {
	private static int count = 0;

	private Lock lock = new ReentrantLock();
	public void add() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread() + "--before add: " + count);
			count++;
			System.out.println(Thread.currentThread() + "--after add: " + count);		
		} finally {
			lock.unlock();
		}
	}
}
