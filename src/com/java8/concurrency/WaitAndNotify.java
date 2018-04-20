package com.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitAndNotify {

	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj);

		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			MyTask t = new MyTask("Thread" + i, obj);
			exec.execute(t);
		}

		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("-----Main Thread notify-----");
			synchronized (obj) {
				obj.notifyAll();
			}

			TimeUnit.SECONDS.sleep(2);
			System.out.println("Main Thread is end.");
			exec.shutdown();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class MyTask implements Runnable {
		private String name;
		private Object co;

		public MyTask(String name, Object o) {
			this.name = name;
			this.co = o;
		}

		@Override
		public void run() {
			System.out.println(name + " is waiting.");
			try {
				synchronized (co) {
					co.wait();
					System.out.println(name + " has been notified.");
					TimeUnit.SECONDS.sleep(2);
//					co.notify();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
