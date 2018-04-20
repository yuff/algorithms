package com.java8.concurrency.exceptionhandler;

public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
