package com.java8.futuretest;

public class Quote {

	private final String shopName;
	private final double price;
	private final Discount.Code discountCode;

	public Quote(String shopName, double price, Discount.Code discountCode) {
		this.shopName = shopName;
		this.price = price;
		this.discountCode = discountCode;
	}

	public String getShopName() {
		return shopName;
	}

	public double getPrice() {
		return price;
	}

	public Discount.Code getDiscountCode() {
		return discountCode;
	}

}
