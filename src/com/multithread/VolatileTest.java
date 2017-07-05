package com.multithread;

public class VolatileTest {

	 static  int i = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				i++;
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				i++;
			}
		});
		
		t1.start();
		t2.start();
		Thread.currentThread().sleep(100);
		System.out.println(i);
	}
}
