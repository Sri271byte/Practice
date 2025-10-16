package com.svs;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		
		String s1="ABC";
		String s2="XYZ";
		
		s1 =s1+s2;
		s2= s1.substring(0, s1.length()-s2.length());
		s1=s1.substring(s2.length());
		System.out.println(s1);
		System.out.println(s2);
		
	}

}


class MapFlatMapSimple {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
            "I love Java",
            "Java Streams are powerful",
            "Map and FlatMap difference"
        );

        System.out.println("=== Using map() ===");
        sentences.stream()
                 .map(sentence -> sentence.split(" "))
                 .forEach(array -> System.out.println(Arrays.toString(array)));

        System.out.println("\n=== Using map() + flatMap() ===");
        sentences.stream()
                 .map(sentence -> sentence.split(" "))
                 .flatMap(Arrays::stream)
                 .forEach(System.out::println);
    }
}