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
    
     //Even Numbers   
     numbers.stream().filter(n-> n % 2 == 0).forEach(System.out::println);
     System.out.println("--------------------------------------------------");
     //odd numbers
     numbers.stream().filter(n-> n % 2 != 0).forEach(System.out::println);
     System.out.println("--------------------------------------------------");
     //Starts with "5"
     numbers.stream().map(String::valueOf)
            .filter(s -> s.startsWith("5")).forEach(System.out::println);
     System.out.println("--------------------------------------------------");
     //unique elements
     numbers.stream().distinct().forEach(System.out::println);
     System.out.println("--------------------------------------------------");
     // Find maximum value
     Optional<Integer> max = numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
     System.out.println("MAX-------------------------------: "+max);
     //  Find minimum value
     Integer min = numbers.stream().max((i,j)-> j.compareTo(i)).get();
     System.out.println("Min-------------------------------: "+  min);
     // sumOf Integer Values
     Optional<Integer> sumOfValues = numbers.stream().reduce((a,b) -> a+b);//a stream into a single result by repeatedly applying a binary operation
     System.out.println("sumOf Integer Values-------------------------------: "+  sumOfValues);
     // Average Integer Values
     double avg=numbers.stream().mapToInt(e -> e).average().getAsDouble();
     System.out.println("Average Integer Values-------------------------------: "+  avg);
     //Sorted Integer Values
     List<Integer>Sorted = numbers.stream().distinct().sorted().collect(Collectors.toList());
     System.out.println("Sorted Integer Values-------------------------------: "+  Sorted);
     //reverseSorted Integer Values
     List<Integer>reverseSorted = numbers.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
     System.out.println("reverseSorted Integer Values-------------------------------: "+  reverseSorted);
     //Print First 5 Integer Values
     List<Integer> l = numbers.stream().limit(5).collect(Collectors.toList());
     System.out.println("Print First 5 Integer Values-------------------------------: "+  l);
     //count First 5 Integer Values
     int count= numbers.stream().limit(5).reduce((p,q) -> p+q).get();
     System.out.println("count First 5 Integer Values-------------------------------: "+  count);
     //Skip First 5 Integer Values
     List<Integer> l1 = numbers.stream().skip(5).collect(Collectors.toList());
     System.out.println("Skip First 5 Integer Values-------------------------------: "+  l1);
     //Second Lowest Integer Value
     int secL = numbers.stream().sorted().distinct().skip(1).findFirst().get();
     System.out.println("Second Lowest Integer Value-------------------------------: "+  secL);
     //Second heigest Integer Value
     int secH = numbers.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
     System.out.println("Second heigest Integer Value-------------------------------: "+  secH);
     
     Set<Integer> result = numbers.stream().filter(n->numbers.indexOf(n)!=numbers.lastIndexOf(n)).collect(Collectors.toSet());
     System.out.println("Print duplicates : "+result);
 
     
	}
}
     
//------------------------------------------------------------------------------------------------------------
	class PrintFirstAndLastSameTypeOfElements{
		public static void main(String[] args) {
			// OutPut : aba,xyx,zzz
			List<String> names = Arrays.asList("aba","cv","xyx","zzz");
			names.stream().filter(x -> x.length() > 0 && x.endsWith(String.valueOf(x.charAt(0))))
			     .forEach(System.out::println);
		}}
//--------------------------------------------------------------------------------------------------------------
	  class MoveZerosRight {
		    public static void main(String[] args) {
		    	//OUT PUT : [0, 0, 0, 1, 1, 1, 1]
		        List<Integer> input = Arrays.asList(1,1,0,1,0,0,1);

		        List<Integer> result = Stream.concat(input.stream().filter(n -> n == 0),
		                                             input.stream().filter(n -> n != 0)
		        ).collect(Collectors.toList());
		        System.out.println(result);
		    }}
//----------------------------------------------------------------------------------------------------------------	  
	  class LetterCountWithOutG{
		  public static void main(String[] args) {
			String word = "Today is good day";
			Map<Character,Long> letterCount = word.chars()//convert the string to intstream
			   .filter(c-> c!='g' && c!='G')	//filter out g		   
			   .filter(Character::isLetter)    // keep only letters
			   .mapToObj(c->(char) c )         //convert Int to charcter
			   .collect(Collectors.groupingBy(c-> c,Collectors.counting())); //collect into map
			
	           System.out.println("Letter count withOut G : "+letterCount);
		}} 
//-------------------------------------------------------------------------------------------------------------------
   class EvenNumberPrinterWithStreams {           // Define the class

      public static void main(String[] args) {          // Entry point of the program
//OUTPUT : (2)(4)(6)(8) , Total even numbers: 4

          List<int[]> pairs = Arrays.asList(            // Create a List of integer arrays (pairs)
              new int[]{1, 2},           // First pair: (1, 2)
              new int[]{3, 4},                          // Second pair: (3, 4)
              new int[]{5, 6},                          // Third pair: (5, 6)
              new int[]{7, 8}                           // Fourth pair: (7, 8)
          );

          long evenCount = pairs.stream()               // Start a stream from the list of int[] pairs
              .flatMapToInt(pair -> Arrays.stream(pair)) // Convert each int[] pair into a stream of integers
              .filter(num -> num % 2 == 0)              // Keep only even numbers (divisible by 2)
              .peek(num -> System.out.print("(" + num + ")")) // Print each even number in brackets
              .count();                                 // Count how many even numbers there were

          System.out.println("\nTotal even numbers: " + evenCount); // Print the total count of even numbers
      }
  }
   
   
 //---------------------------------------------------------------------------------------------------------------  
      class Singleton {                     // Define the Singleton class

	    private static Singleton instance;       // Static variable to hold the single instance
	    private Singleton() {                    // Private constructor prevents instantiation from outside
	        // Optional: initialization code
	    }

	    public static synchronized Singleton getInstance() {  // Public method to return the instance
	        if (instance == null) {                            // If instance is not created yet
	            instance = new Singleton();                    // Create the instance
	        }
	        return instance;                                   // Return the single instance
	    }

	    public void showMessage() {                // Example method to test the singleton
	        System.out.println("Hello from Singleton!");
	    }
	    
	    	public static void main(String[] args) {
	    	      
	    	  Singleton obj1 = Singleton.getInstance();
	    	          System.out.println(obj1);
	    	  Singleton obj2= Singleton.getInstance();
	    	          System.out.println(obj2);
	    	  Singleton obj3= Singleton.getInstance();
	    	          System.out.println(obj3);
	      }
	    	 
	}
//-----------------------------------------------------------------------------------------------------
    
     class DeadlockExample {
             // Two shared resources (locks)
        private static final Object Lock1 = new Object();
        private static final Object Lock2 = new Object();

        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                synchronized (Lock1) {                                // Thread 1 locks Lock1
                    System.out.println("Thread 1: Holding Lock1...");

                    try { Thread.sleep(100); } catch (Exception e) {} // Wait to increase chance of deadlock

                    System.out.println("Thread 1: Waiting for Lock2...");
                    synchronized (Lock2) {                            // Thread 1 tries to lock Lock2
                        System.out.println("Thread 1: Acquired Lock2!");
                    }}
            });

            Thread thread2 = new Thread(() -> {
                synchronized (Lock2) {                                // Thread 2 locks Lock2
                    System.out.println("Thread 2: Holding Lock2...");

                    try { Thread.sleep(100); } catch (Exception e) {} // Wait to increase chance of deadlock

                    System.out.println("Thread 2: Waiting for Lock1...");
                    synchronized (Lock1) {                            // Thread 2 tries to lock Lock1
                        System.out.println("Thread 2: Acquired Lock1!");
                    }}
            });

            thread1.start();  // Start Thread 1
            thread2.start();  // Start Thread 2
        }
    }
//--------------------------------------------------------------------------------------------------------------
   class PrintLastStringValue{
	   public static void main(String[] args) {
		
		   List<String> names = Arrays.asList("srikanth","svs","pavan","Ram");
		   String result = names.stream().skip(names.size()-1).findFirst().get();
		   System.out.println(result);
	   }}
//[--------------------------------------------------------------------------------------------  
   class FindTheSecondHighestValueAndRemoveDuplicates{ 
	   public static void main(String[] args) {
		   
		List<Integer> ar = Arrays.asList(3,3,2,3,1);  
		Integer k =  ar.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(k);	   
	}}
   //----------------------------------------------------------------------------------
       class ReversePairing {
    	    public static void main(String[] args) {
    	    	//OUT PUT : 1,3 2,2 0,5
    	        int[] input = {1, 2, 0, 4, 5, 2, 3};

    	        for (int i = 0; i < input.length / 2; i++) {
    	            int left = input[i];
    	            int right = input[input.length - 1 - i];
    	            System.out.println(left + "," + right);
    	        }}}
//----------------------------------------------------------------------------
        class PairSum {

           public static void findPairSum(int[] arr, int targetSum) {
               Map<Integer, Integer> numMap = new HashMap<>(); // Stores number and its index

               for (int i = 0; i < arr.length; i++) {
                   int currentNum = arr[i];
                   int complement = targetSum - currentNum;

                   if (numMap.containsKey(complement)) {
                       System.out.println("Pair found: (" + complement + ", " + currentNum + ")");
                       // If you need indices: System.out.println("Pair found at indices: (" + numMap.get(complement) + ", " + i + ")");
                   }
                   numMap.put(currentNum, i); // Store the current number and its index
               }}

           public static void main(String[] args) {
        	   //OUT PUT : Pair found: (1, 7) Pair found: (5, 3) Pair found: (2, 6)
               int[] numbers = {1, 5, 7, -1, 5, 3, 2, 6};
               int target = 8;
               findPairSum(numbers, target);
           }
       }
 //---------------------------------------------------------------------------------------  

         class WordFrequency {
            public static void main(String[] args) {
                // Step 1: Define the input array of words
                String[] arr = {"home", "svs", "home", "svs", "svs"};

                // Step 2: Create a HashMap to store word frequencies
                Map<String, Integer> freqMap = new HashMap<>();

                // Step 3: Loop through each word in the array
                for (String word : arr) {
                    // Step 4: Update the frequency count in the map
                    freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                }

                // Step 5: Loop through the map entries and print the frequencies
                for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }}}
       //--------------------------------------------------------------------------------------
         class WordFrequencyJava8 {
        	    public static void main(String[] args) {
        	        // Step 1: Input array
        	       // String[] arr = {"home", "svs", "home", "svs", "svs"};
        	    	
        	    	Integer  [] arr = {1,2,3,4,2,4,3,2,4,5,2};
        	    	
        	    

        	        // Step 2: Use Java 8 Streams to count word frequency
        	        Map<Integer, Long> freqMap = Arrays.stream(arr)
        	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        	        // Step 3: Print the result
        	        freqMap.forEach((word, count) -> System.out.println(word + " : " + count));
        	    }
        	}
 //---------------------------------------------------------------------------------------------------------        
         
class exceptionnn {
public static void main(String[] args) {
	

         List<String> list = new ArrayList<>();
         list.add("A");
         list.add("B");

         for (String item : list) {
             if (item.equals("B")) {
                 list.remove(item);  // ConcurrentModificationException
             }
         }}}
//------------------------------------------------------------------------------------------
          class RemoveDuplicateWordsJava8 {
        	    public static void main(String[] args) {
        	        String str = "I am Java Developer Developer";

        	        String result = Arrays.stream(str.split("\\s+")) // Split by whitespace
        	                .distinct()                              // Remove duplicates (Java 8 stream)
        	                .collect(Collectors.joining(" "));       // Join back to string

        	        System.out.println("Original: " + str);
        	        System.out.println("Without duplicates: " + result);
        	    }
        	}
 //------------------------------------------------------------------------------------------------         
          
           class RemoveDuplicateWordsJava81 {
        	    public static void main(String[] args) {
        	        String str = "I am Java Developer Developer";

        	        String result = Arrays.stream(str.split("\\s+"))
        	                .collect(Collectors.toCollection(LinkedHashSet::new)) // removes duplicates, preserves order
        	                .stream()
        	                .collect(Collectors.joining(" ")); // re-join into a string

        	        System.out.println("Original: " + str);
        	        System.out.println("Without duplicates: " + result);
        	    }
        	}
 // ------------------------------------------------------------------------------------------------------------        
          
          
          
          
          
          
          
          
          
