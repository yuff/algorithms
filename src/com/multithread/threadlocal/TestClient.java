package com.multithread.threadlocal;

public class TestClient extends Thread {

	private SequenceNumber sn;
	private NoteBooks nb;

	public TestClient(SequenceNumber sn) {
		this.sn = sn;
	}

	public TestClient(SequenceNumber sn, NoteBooks nb) {
		this.sn = sn;
		this.nb = nb;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			StringBuilder builder = new StringBuilder("thread[").append(Thread.currentThread().getName())
			                                                    .append("],sn[").append(sn.getNextNum()).append("]");
			if (nb != null) {
				builder.append(",bookname[");
				builder.append(nb.getBookName(i));
				builder.append("]");
				nb.removeThreadLocal();
			}
			System.out.println(builder.toString());
		}
		sn.removeThreadLocal();
	}
}
