package com.multithread.lock;

public class CounterTask implements Runnable{

	private Counter counter;
	public CounterTask(Counter counter) {
		this.counter = counter;
	}
	@Override
	public void run() {
//		this.counter.add();
		Counter.addStatic();
//		this.counter.addBlock();
		Counter.addStaticBlock();
	}

}
