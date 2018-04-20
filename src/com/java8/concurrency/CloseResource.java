package com.java8.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server= new ServerSocket(8280);
		InputStream socketInput = new Socket("localhost",8280).getInputStream();
		exec.execute(new IOBlocked(socketInput));
//		exec.execute(new IOBlocked(System.in));
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("shutting down all threads");
		exec.shutdownNow();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Closing " + socketInput.getClass().getSimpleName());
		socketInput.close();
//		TimeUnit.SECONDS.sleep(1);
//		System.out.println("Closing " + System.in.getClass().getSimpleName());
//		System.in.close();
	}
}
