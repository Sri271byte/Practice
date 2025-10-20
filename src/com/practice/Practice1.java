package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice1 {
	
	public static void main(String[] args) {
		
	
	
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,5,56,57,8,9,10);
    
     
     //Starts with "5"
     
  

     // sumOf Integer Values
     Optional<Integer> sumOfValues = numbers.stream().reduce((a,b) -> a+b);//a stream into a single result by repeatedly applying a binary operation
     System.out.println("sumOf Integer Values-------------------------------: "+  sumOfValues);
     // Average Integer Values
     double avg=numbers.stream().mapToInt(e -> e).average().getAsDouble();
     System.out.println("Average Integer Values-------------------------------: "+  avg);
     
     Map<Object, Long> count =  numbers.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
     System.out.println(count);
     
     List<Integer> li=numbers.stream().filter(n->n% 2!=0).collect(Collectors.toList());
     System.out.println("even:"+li);
     
	}
}
     

  
      
          
          
          
          
          
          
          
          
