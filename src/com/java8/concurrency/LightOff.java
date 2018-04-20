package com.java8.concurrency;

public class LightOff implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LightOff() {
		
	}
	public LightOff(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return Thread.currentThread() + "#" + id + "(" +  (countDown > 0? countDown : "Light off!") + ").";
	}
	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			if (countDown % 3 == 0) {
				throw new RuntimeException();
			}
			Thread.yield();
		}

	}

}
