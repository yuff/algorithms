package com.java8.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pet{}
class Cat extends Pet{}
class Dog extends Pet{}
public class CheckedList {

	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());
		System.out.println("oldStyleMethod===" + probablyDogs);
	}
	public static void main(String[] args) {
		List<Dog> dog1 = new ArrayList<>();
		oldStyleMethod(dog1);
		System.out.println("get dog from dog1:");
		Object dogo = dog1.get(0);
		System.out.println(dogo.getClass().getSimpleName());
		Dog dog = dog1.get(0);
		System.out.println(dog);
		List<Dog> dog2 = Collections.checkedList(new ArrayList<>(), Dog.class);
		try {
			oldStyleMethod(dog2);
		} catch(Exception e) {
			System.out.println(e);
		}
		List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
	}
}
