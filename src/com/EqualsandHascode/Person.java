package com.EqualsandHascode;
import java.util.Objects;

	public class Person {
		
		
		
	    private String name;

	    public Person(String name) {
	        this.name = name;
	    }

	    // Overriding equals()
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;  // same reference
	        if (o == null || getClass() != o.getClass()) return false; // null or different class

	        Person person = (Person) o;
	        return Objects.equals(name, person.name); // comparing by name
	    }

	    // Overriding hashCode()
	    @Override
	    public int hashCode() {
	        return Objects.hash(name); // hash code based on name
	    }

	    @Override
	    public String toString() {
	        return "Person{name='" + name + "'}";
	    }
	}



