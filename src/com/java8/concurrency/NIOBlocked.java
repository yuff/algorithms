package com.java8.concurrency;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

public class NIOBlocked implements Runnable {

	private final SocketChannel sc;
	private final String name;

	public NIOBlocked(SocketChannel sc, String name) {
		this.sc = sc;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			System.out.println("Waiting for read in " + name);
			sc.read(ByteBuffer.allocate(1));
		}
		catch (ClosedByInterruptException e) {
			System.out.println(this.name + " ClosedByInterruptException");
		}
		catch (AsynchronousCloseException e) {
			System.out.println(this.name + " AsynchronousCloseException");
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println(this.name + " Exiting NIOBlocked.run()");

	}

}
