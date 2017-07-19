package com.java8.clonetest;

import java.io.IOException;

public class CloneTest {

	public static void main(String[] args) {
		WeeklyLog log1 = new WeeklyLog();
		log1.setName("Bob");
		log1.setDate("Week 12");
		log1.setContent("Busy week");
		
		System.out.println("****周报****");
        System.out.println("周次：" +  log1.getDate());
        System.out.println("姓名：" +  log1.getName());
        System.out.println("内容：" +  log1.getContent());
        System.out.println("--------------------------------");
        
        WeeklyLog log2 = log1.clone();
        log2.setDate("Week 13");
        
		System.out.println("****周报****");
        System.out.println("周次：" +  log2.getDate());
        System.out.println("姓名：" +  log2.getName());
        System.out.println("内容：" +  log2.getContent());
        System.out.println("--------------------------------");
        
        System.out.println(log1 == log2);
        System.out.println(log1.getDate() == log2.getDate());
        System.out.println(log1.getName() == log2.getName());
        System.out.println(log1.getContent() == log2.getContent());
        
        WeeklyLogWithAttachment log3 = new WeeklyLogWithAttachment();
		log3.setName("Bob");
		log3.setDate("Week 12");
		log3.setContent("Busy week");
		Attachment a = new Attachment();
		a.setName("attachment!");
		
		log3.setAttachment(a);
		
		try {
			WeeklyLogWithAttachment log4 = log3.deepClone();
			log4.setDate("week 13");
			
			log3.getAttachment().setName("Update");
			
			System.out.println("****周报****");
	        System.out.println("周次：" +  log4.getDate());
	        System.out.println("姓名：" +  log4.getName());
	        System.out.println("内容：" +  log4.getContent());
	        System.out.println("内容：" +  log4.getAttachment().getName());
	        System.out.println("--------------------------------");
		}
		catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
