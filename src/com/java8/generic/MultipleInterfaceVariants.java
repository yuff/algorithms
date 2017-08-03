package com.java8.generic;

interface Payable<T> {
}

class Employee implements Payable<Employee> {
}

// class Hourly extends Employee implements Payable<Hourly>{} //compile error
public class MultipleInterfaceVariants {

}
