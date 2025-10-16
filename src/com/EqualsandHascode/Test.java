package com.EqualsandHascode;

public class Test {
	
	 public static void main(String[] args) {
	        Person p1 = new Person("Alice");
	        Person p2 = new Person("Alice");
	        Person p3 = new Person("Bob");

	        System.out.println(p1.equals(p2)); // true
	        System.out.println(p1.equals(p3)); // false

	        System.out.println(p1.hashCode() == p2.hashCode()); // true (same name)
	        System.out.println(p1.hashCode() == p3.hashCode()); // probably false
	    }

}
