package com.jvm;

public class BookMain {

	public static void main(String[] args) {
		System.out.println(Book.price == Book1.price);
		Book book = new Book();
		Book1 book1 = new Book1();
		System.out.println(book.name == book1.name);
		System.out.println(book.price1 == Book.price);
		System.out.println(book.name == book1.name1);
		System.out.println(Book.description == Book1.description);
	}
}
