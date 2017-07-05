package com.java8.futuretest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class ShopList {

	List<Shop> shops = Arrays.asList(new Shop("BestShop"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"),
	                                 new Shop("BuyItAll"), new Shop("BestShop_1"), new Shop("LetsSaveBig_1"),
	                                 new Shop("MyFavoriteShop_1"),
	                                 new Shop("BuyItAll_1"), new Shop("BestShop_2"), new Shop("LetsSaveBig_2"),
	                                 new Shop("MyFavoriteShop_2"),
	                                 new Shop("BuyItAll_2"));
	private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});

	public List<String> findPrices(String product) {
		return shops.parallelStream()
		            .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
		            .collect(Collectors.toList());
	}

	public List<String> findPricesWithDiscount(String product) {
		return shops.parallelStream()
		            .map(shop -> shop.getPriceWithDiscount(product)).map(Discount::applyDiscount)
		            .collect(Collectors.toList());
	}

	public List<String> findPricesAsync(String product) {
		List<CompletableFuture<String>> priceFutures =
		                shops.stream()
		                     .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
		                                                                      shop.getPrice(product),
		                                                                executor))
		                     .collect(Collectors.toList());
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

	public List<String> findPricesWithDiscountAsync(String product) {
		List<CompletableFuture<String>> priceFutures = shops.stream()
		                                                    .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceWithDiscount(product),
		                                                                                               executor))
		                                                    .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote),
		                                                                                                                             executor)))
		                                                    .collect(Collectors.toList());
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(new ShopList().findPricesWithDiscount("myPhone27s"));
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("findPricesWithDiscount Done in " + duration + "msecs");

		start = System.nanoTime();
		System.out.println(new ShopList().findPricesWithDiscountAsync("myPhone27s"));
		duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println("findPricesWithDiscountAsync Done in " + duration + "msecs");
	}
}
