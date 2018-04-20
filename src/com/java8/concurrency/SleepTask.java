package com.java8.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SleepTask implements Callable<Integer> {

	Random rand = new Random();
	@Override
	public Integer call() throws Exception {
		int inter = rand.nextInt(10);
		TimeUnit.MILLISECONDS.sleep(inter);
		System.out.println(Thread.currentThread() + " sleep " + inter + " ms");
		return inter;
	}

}
