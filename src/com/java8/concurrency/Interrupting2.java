package com.java8.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interrupting2 {

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing t.interrupt()");
		t.interrupt();
	}
}

class BlockedMutex {
	private Lock lock = new ReentrantLock();
	public BlockedMutex() {
		lock.lock();
	}
	
	public void g() {
		try {
			lock.lock();
			System.out.println("lock acquired in g()");
			f();
			
		} finally {
			lock.unlock();
		}
	}
	public void f() {
		try {
//			if(lock.tryLock())
			lock.lockInterruptibly();
			System.out.println("lock acquired in f()");
		} catch(InterruptedException e) {
			System.out.println("Interrupted from lock acquisition in f()");
		} finally {
			System.out.println("finally");
		}
	}
}

class Blocked2 implements Runnable {
	BlockedMutex blocked = new BlockedMutex();
	public void run() {
		System.out.println("Waiting for f() in BlockedMutex");
		blocked.f();
		System.out.println("Broken out of blocked call");
	}
}