package com.LambdaComarator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaComparatorExample {
	public static void main(String[] args) {
		
		
		List<Employee> list = Arrays.asList(
	            new Employee("Alice", 30, 60000),
	            new Employee("Bob", 25, 50000),
	            new Employee("Charlie", 35, 70000)
	        );

	        // Sort by name using lambda
	       
			/*
			 * list.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
			 * list.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
			 * list.sort((e1,e2)-> Integer.compare(e1.getAge(), e2.getAge()));
			 */
	        //
		
		//list.sort(Comparator.comparing(Employee::getAge).reversed());
	        
	        Employee.sort(
	        	    Comparator.comparing(Employee::getSalary)
	        	              .thenComparing(Comparator.comparing(Employee::getAge)));

	        list.forEach(System.out::println);
	}

}

class Employee {
    private String name;
    private int age;
    private double salary;

    // constructor, getters
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static void sort(Comparator<Employee> thenComparing) {
		// TODO Auto-generated method stub
		
	}

	public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}