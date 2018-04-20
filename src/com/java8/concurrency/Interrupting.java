package com.java8.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException occured");
		}
		System.out.println("Exit SleepintBlocked.run()");
	}	
}

class IOBlocked implements Runnable {
	private InputStream in;
	public IOBlocked(InputStream in) {
		this.in = in;
	}
	@Override
	public void run() {
		try {
			System.out.println("Waiting for read() from " + in.getClass().getSimpleName());
			in.read();
		} catch(IOException e) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupted from blocked I/O " + in.getClass().getSimpleName());
			} else {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exit IOBlocked.run() from " + in.getClass().getSimpleName());
	}
}

class SynchronizedBlocked implements Runnable {
	public synchronized void f() {
		while (true) {
			Thread.yield();
		}
	}
	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f();
			}
		}.start();
	}
	public void run() {
		System.out.println("Trying to call f()");
		f();
		System.out.println("Exit SynchronizedBlocked.run()" );
	}
}
public class Interrupting {

	private static ExecutorService exec = Executors.newCachedThreadPool();
	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting " + r.getClass().getSimpleName());
		f.cancel(true);
		System.out.println("Interrupt sent to " + r.getClass().getSimpleName());
	}
	public static void main(String[] args) throws Exception {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0)");
		System.exit(0);
	}
}
