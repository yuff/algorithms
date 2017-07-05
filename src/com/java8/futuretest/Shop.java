package com.java8.futuretest;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

	private String name;

	public Shop(String name) {
		this.name = name;
	}

	public Quote getPriceWithDiscount(String product) {
		double price = getPrice(product);
		Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
		return new Quote(name, price, code);
	}

	public double getPrice(String product) {
		return calculatePrice(product);
	}

	public String getName() {
		return name;
	}

	public Future<Double> getPriceAsyncByFactory(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}

	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			try {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			}
			catch (Exception ex) {
				futurePrice.completeExceptionally(ex);
			}
		}).start();
		return futurePrice;
	}

	private double calculatePrice(String product) {
		delay();
		return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
		// throw new RuntimeException("error when calculate price");
	}

	public static void delay() {
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

}
