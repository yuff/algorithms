package com.java8.datetest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

public class LocalDateTest {

	@Test
	public void testLocalDate() {
		LocalDate date = LocalDate.of(2017, 6, 22);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean leap = date.isLeapYear();
		System.out.println("date " + date);
		System.out.println("year " + year);
		System.out.println("day " + day);
		System.out.println("month " + month);
		System.out.println("dow " + dow);
		System.out.println("len of month " + len);
		System.out.println("leap " + leap);
		System.out.println("len of year " + date.lengthOfYear());
		System.out.println("now:" +  LocalDate.now());
	}
	
	@Test
	public void testLocalDateTime() {
		LocalDate date = LocalDate.of(2017, 6, 22);
		LocalDateTime dt = date.atTime(16, 49, 44);
		System.out.println(dt);
	}
	
	@Test
	public void testLocalDateParse() {
		LocalDate date = LocalDate.of(2017, 6, 22);
		LocalDate date1 = date.withYear(2018);
		System.out.println(date);
		System.out.println(date1);
		LocalDate date2 = date.plusWeeks(2);
		System.out.println(date2);
	}
}
