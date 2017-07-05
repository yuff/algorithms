package com.java8.streamtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamDemo {

	List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
	                                new Dish("beef", false, 700, Dish.Type.MEAT),
	                                new Dish("chicken", false, 400, Dish.Type.MEAT),
	                                new Dish("french fries", true, 530, Dish.Type.OTHER),
	                                new Dish("rice", true, 350, Dish.Type.OTHER),
	                                new Dish("season fruit", true, 120, Dish.Type.OTHER),
	                                new Dish("prawns", false, 300, Dish.Type.FISH),
	                                new Dish("salmon", false, 450, Dish.Type.FISH));

	@Test
	public void testStreamThreeHighCaloricDisNames() {
		List<String> treeHighCaloricDisNames = menu.stream().filter(d -> {
			System.out.println("filtering: " + d.getName());
			return d.getCalories() > 300;
		}).map(d -> {
			System.out.println("mapping: " + d.getName());
			return d.getName();
		}).limit(3).collect(Collectors.toList());
		System.out.println(treeHighCaloricDisNames);
	}

	@Test
	public void testGetFirstTwoMeat() {
		menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).map(Dish::getName)
		    .forEach(System.out::println);

	}

	@Test
	public void testDishNameLength() {
		List<Integer> result = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
		System.out.println(result);
	}

	@Test(expected = IllegalStateException.class)
	public void testMultiConsumeStream() {
		List<String> title = Arrays.asList("Java8", "In", "Action");
		Stream<String> s = title.stream();
		s.forEach(System.out::println);
		s.forEach(System.out::println);
	}

	@Test
	public void testDistinct() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 6, 2, 2);
		numbers.stream().skip(2).filter(i -> i % 2 == 0).distinct().limit(2).forEach(System.out::println);
	}

	@Test
	public void testFlatMap() {
		String[] array = {"Hello", "World"};
		Arrays.stream(array).map(s -> s.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);
	}

	@Test
	public void testSquareArray() {
		int[] numbers = {1, 2, 3, 4, 5, 6};
		Arrays.stream(numbers).map(i -> i * i).forEach(System.out::println);
	}

	@Test
	public void testFilter() {
		String[] array = {"Hello", "World"};
		boolean result = Arrays.stream(array).filter(role -> isUserInJwtRole(role)).count() > 0;
		System.out.println(result);
	}

	private boolean isUserInJwtRole(String role) {
		List<String> roles = new ArrayList<>();
		// roles.add("Hello");
		// roles.add("World");
		return roles.contains(role);
	}

	public int minMoves(int[] nums) {
		int min = Arrays.stream(nums).reduce(Integer::min).getAsInt();
		return Arrays.stream(nums).map(d -> d - min).reduce(Integer::sum).getAsInt();
	}

	@Test
	public void testMinMoves() {
		StreamDemo demo = new StreamDemo();
		int[] nums = {1, 9, 3};
		System.out.println(demo.minMoves(nums));

	}
}
