package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeJava8String {

	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("sun", "moon", "star","apple","star", "skystar", "apple", "sand");
		
		List<String> ar = Arrays.asList("apple Banana Cherry","banana cherry");
		
		Map<Character, List<String>> grouped = list1.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println("Print Starts with Same Letter :"+grouped);
		
	        List<String> sv= list1.stream().filter(str->str.startsWith("s")).distinct().collect(Collectors.toList());
			System.out.println("starts with S: "+sv);
			
		    List<String> sd= IntStream.range(0, list1.size()).mapToObj(i -> list1.get(list1.size() - 1 - i)).collect(Collectors.toList());
		    System.out.println("Words reverse : "+sd);
		    
		     List<String> reversedList = list1.stream() .map(s -> new StringBuffer(s).reverse().toString()).collect(Collectors.toList());
		     System.out.println("Words reverse : "+reversedList);
		    
		    Map<String, Long> frequency = list1.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		    System.out.println("frequency of each word"+ frequency);
		    
		    Set<String> duplicates = list1.stream().filter(s -> Collections.frequency(list1, s) > 1).collect(Collectors.toSet());
		    System.out.println("Duplicates: " + duplicates);
		    
		    String maxLengthWord = list1.stream().max(Comparator.comparingInt(String::length)).get();
		    System.out.println("Word with max length: " + maxLengthWord);
		    
		    String result = list1.stream().map(word -> "\"" + word + "\":" + word.length()).collect(Collectors.joining(", "));
		    System.out.println("Count each word length :"+result);

		    Long WordLength=  list1.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.counting());
		    System.out.println("Total Words : " + WordLength);
		    
		    Map<String, Long> wordCount = ar.stream()
		            .flatMap(str -> Arrays.stream(str.split(" ")))
		            .map(word -> word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase()) // normalize case
		            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		    System.out.println("List of sub Strings count  : "+wordCount);

		  

	}
}



 