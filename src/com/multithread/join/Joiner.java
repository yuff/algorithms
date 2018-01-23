package com.multithread.join;

public class Joiner extends Thread {
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	public void run() {
		try {
			sleeper.join();
		} catch(InterruptedException e) {
			System.out.println(getName() + " was interrupted." + ", isInterrupted:" + isInterrupted());
			return;
		}
		System.out.println(getName() + " join compelete.sleeper.isAlive():" + sleeper.isAlive());
	}
	
	public void printStatus() {
		System.out.println(sleeper.isAlive());
	}
}
