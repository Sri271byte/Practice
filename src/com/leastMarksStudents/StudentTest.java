package com.leastMarksStudents;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentTest {
	
	
	
	
	public static void main(String[] args) {

		  List<Student> students = new ArrayList<>();

	        // Populate with 100 students (example)
	        for (int i = 1; i <= 100; i++) {
	            students.add(new Student("Student" + i, (int) (Math.random() * 100)));
	        }

	        // Get bottom 20 students by score
	        List<Student> least20 = students.stream()
	            .sorted(Comparator.comparingInt(Student::getScore)) // Ascending order
	            .limit(20)
	            .collect(Collectors.toList());

	        // Print them
	        System.out.println("Bottom 20 scoring students:");
	        least20.forEach(System.out::println);
	}
	
}

	
class Student {
	

    private String name;
    private int score;

    // Constructor
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // For printing
    @Override
    public String toString() {
        return name + ": " + score;
    }


}
