package com.multithread.threadlocal;

public class SequenceNumber {

	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	
	public void removeThreadLocal() {
		seqNum.remove();
	}

	public static void main(String[] args) {
		SequenceNumber sn = new SequenceNumber();
		NoteBooks nb = new NoteBooks();
		TestClient tc1 = new TestClient(sn, nb);
		TestClient tc2 = new TestClient(sn);
		TestClient tc3 = new TestClient(sn);
		tc1.start();
		tc2.start();
		tc3.start();
	}

}
