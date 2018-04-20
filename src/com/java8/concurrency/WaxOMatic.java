package com.java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
	private boolean waxOn = false;
	public void print() {
		System.out.println("~~");
	}
	public synchronized void waxed() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(50);
		waxOn = true;
		System.out.println("set WaxOn = true");
		notify();
//		notifyAll();
	}
	public synchronized void buffed() throws InterruptedException {
		waxOn = false;
		System.out.println("set WaxOn = false");
		notify();
//		notifyAll();
	}	
	public synchronized void waitForWaxing() throws InterruptedException {
		while (waxOn == false) {
			wait();
			System.out.println("after waitForWaxing " + waxOn);
		}
		System.out.println("waitForWaxing finished");
	}
	
	public synchronized void waitForBuffing() throws InterruptedException {
		while (waxOn) {
			wait();
			System.out.println("after waitForBuffing " + waxOn);
		}
		System.out.println("waitForBuffing finished");
	}
}

class WaxOn implements Runnable {
	private Car car;
	public WaxOn(Car car) {
		this.car = car;
	}
	public void run(){
		try {
			while (!Thread.interrupted()) {
				car.print();
				System.out.println("Wax On!");
//				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch(InterruptedException e) {
			System.out.println("WaxOn Exiting via interrupt");
		}
		System.out.println("Ending Wax On Task");
	}
}

class WaxOff implements Runnable {
	private Car car;
	public WaxOff(Car car) {
		this.car = car;
	}
	public void run(){
		try {
			while (!Thread.interrupted()) {
				car.print();
				car.waitForWaxing();
				System.out.println("Wax Off!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch(InterruptedException e) {
			System.out.println("WaxOff Exiting via interrupt");
		}
		System.out.println("Ending Wax off Task");
	}
}

public class WaxOMatic {

	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}
