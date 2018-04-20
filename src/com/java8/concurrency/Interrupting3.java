package com.java8.concurrency;

import java.util.concurrent.TimeUnit;

public class Interrupting3 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked3());
		t.start();
		TimeUnit.MILLISECONDS.sleep(1100);
		t.interrupt();
	}
}
class NeedsCleanup {
	private final int id;
	public NeedsCleanup(int id) {
		this.id = id;
		System.out.println("NeedsCleanup " + this.id);
	}
	public void cleanup() {
		System.out.println("Cleaning up " + this.id);
	}
}
class Blocked3 implements Runnable {
	private volatile double d = 0.0;
	public void run() {
		try {
			while (!Thread.interrupted()) {
				NeedsCleanup n1 = new NeedsCleanup(1);
				try {
					System.out.println("Sleeping");
					TimeUnit.SECONDS.sleep(1);
					NeedsCleanup n2 = new NeedsCleanup(2);
					try {
						System.out.println("Calculating");
						int i = 0;
						while(i < 2500000) {
							d += (Math.PI + Math.E) / d;
							i++;
						}
						System.out.println("Finished time-consuming operation, i = " + i);
					} finally {
						n2.cleanup();
					}
				} finally {
					n1.cleanup();
				}
			}
			System.out.println("Exiting via while() test");
		} catch (InterruptedException e) {
			System.out.println("Exit via InterruptedException");
		}
	}
}