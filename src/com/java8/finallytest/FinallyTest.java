package com.java8.finallytest;

class Address {
	Address(String country, String city) {
		this.country = country;
		this.city = city;
	}
	String city;
	String country;
	
	@Override
	public String toString() {
		return country + "," + city;
	}
}
public class FinallyTest {

	int count = 1;
	Address address = new Address("CN","SH");
	
	public int getCount() {
		try{
			return count;
		} finally {
			count = 2;
		}
	}
	
	public Address getAddress() {
		try {
			return address;
		} finally {
			address.city = "BJ";
		}
	}
	
	public static void main(String[] args) {
		FinallyTest ft = new FinallyTest();
		System.out.println(ft.getCount());
		System.out.println(ft.count);
		System.out.println(ft.getAddress());
		System.out.println(ft.address);
		
	}
}
