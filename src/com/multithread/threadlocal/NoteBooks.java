package com.multithread.threadlocal;

public class NoteBooks {

	public NoteBooks() {
		// TODO Auto-generated constructor stub
	}

	private static String[] bookList = {"Thinking in Java", "Head First Design Pattern", "Spring in Action"};
	private static ThreadLocal<String> bookName = new ThreadLocal<String>();

	public String getBookName(int i) {
		bookName.set(bookList[i % 3]);
		return bookName.get();
	}
	
	public void removeThreadLocal() {
		bookName.remove();
	}
}
