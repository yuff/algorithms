package com.java8.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 100; i++) {
			exec.execute(new LightOff(5));
			Future<Integer> result = exec.submit(new SleepTask());
			if (result.isDone()) {
				try {
					System.out.println(result.get());
				}
				catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
//		exec.shutdown();
	}
}
