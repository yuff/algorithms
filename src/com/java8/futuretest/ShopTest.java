package com.java8.futuretest;

import java.util.concurrent.Future;

public class ShopTest {

	public static void main(String[] args) {
		getPriceFromBestShop();
	}

	private static void getPriceFromBestShop() {
		Shop shop = new Shop("BestShop");
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsyncByFactory("my favorite product");
		long invocationTime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Invocation returned after " + invocationTime + " mecs");
		doSomethingElse();
		try {
			double price = futurePrice.get();
			System.out.printf("Pirce is %.2f%n", price);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		long retievalTRime = (System.nanoTime() - start) / 1_000_000;
		System.out.println("Price returned after " + retievalTRime + " mecs");
	}

	private static void doSomethingElse() {
		System.out.println("do something else");
	}

}
