package com.multithread.lock;

public class MutexCounterTask implements Runnable {

	private MutexCounter mc;
	public MutexCounterTask(MutexCounter mc) {
		this.mc = mc;
	}
	@Override
	public void run() {
		mc.add();
	}

}
