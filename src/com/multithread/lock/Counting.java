package com.multithread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counting {

	public static void main(String[] args) {
		Counter counter = new Counter();
		MutexCounter mc = new MutexCounter();
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++) {
			CounterTask task1 = new CounterTask(counter);
			MutexCounterTask mct = new MutexCounterTask(mc);
			es.submit(task1);	
//			es.submit(mct);	
		}
	}
}
