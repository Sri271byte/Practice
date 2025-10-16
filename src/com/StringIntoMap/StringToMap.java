package com.StringIntoMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringToMap {

	public static void main(String[] args) {

		 String s = "Hi my name is Satish, and from hyderabad";
	        String[] words = s.split(" ");
	        Map<Integer, String> map = new HashMap<>();

	        for (int i = 0; i < words.length; i++) {
	            map.put(i, words[i]);
	        }

	        // Print the map
	        for (Map.Entry<Integer, String> entry : map.entrySet()) {
	            System.out.println(entry.getKey() + " -> " + entry.getValue());
	        }}}

class StringTooMap {
    public static void main(String[] args) {
        String s = "Hi my name is Satish, and from hyderabad";

        Map<String, String> map = new HashMap<>();
        map.put("sentence", s);

        // Print the original sentence from the map
        System.out.println(map.get("sentence"));
    }
}
 class Main {
    public static void main(String[] args) {
    	
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 3, 2, 22);
        List<Integer> list2 = Arrays.asList(2, 25, 5, 4, 3);

        List<Integer> result = Stream.concat(list1.stream(), list2.stream())
                .filter(i -> String.valueOf(i).startsWith("2"))
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
 
 
  class Main1 {
	    public static void main(String[] args) {
	        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

	        // Using lambda expression
	        names.forEach(name -> System.out.println(name));
	    }
	}
 
 
  class Main3 {
	    public static void main(String[] args) {
	        List<String> fruits = Arrays.asList("apple", "banana", "apricot", "grape");

	        long count = fruits.stream()
	                .filter(fruit -> fruit.startsWith("a"))
	                .count();

	        System.out.println(count); // 2
	    }
	}
  
  //=======================================================================================================================
  
  class PredicateExample {
	    public static void main(String[] args) {
	        Predicate<Integer> isEven = num -> num % 2 == 0;
	        System.out.println(isEven.test(4)); // true
	        System.out.println(isEven.test(5)); // false
	    }
	}
  
   class ConsumerExample {
	    public static void main(String[] args) {
	        Consumer<String> greet = name -> System.out.println("Hello, " + name);
	        greet.accept("Srikanth"); // Output: Hello, Srikanth
	    }
   }
   
  class SupplierExample {
	    public static void main(String[] args) {
	        Supplier<Double> randomValue = () -> Math.random();
	        System.out.println(randomValue.get()); // e.g., 0.7483
	    }
	}

  class FunctionExample {
	    public static void main(String[] args) {
	        Function<String, Integer> length = s -> s.length();
	        System.out.println(length.apply("Lambda")); // 6
	    }
	}
  
  class Example {
	    public static void main(String[] args) {
  List<Integer> Ar = Arrays.asList(1, 3, 4, 6, 8);

  for (int i = 0; i < Ar.size(); i++) {
      if (Ar.get(i) == 4) {
          System.out.println(Ar.get(i));
      }
  }
	    }}
  
  class print4{
	  public static void main(String[] args) {
		
		  List<Integer> Arr = Arrays.asList(1,2,3,4,5);
		  List<Integer> s= Arr.stream().filter(e->e==4).collect(Collectors.toList());
		  System.out.println(s);
	}
  }
 
  
 class waste{
	 public static void main(String[] args) {
		 String s1 = new String("Hi");
		 String e = s1.concat("Bro");
		 String s2 = "Hi";
		 String e1 = s2.concat("Bro"); 

		  String S3=s1+s2;
		  System.out.println(e);
		  System.out.println(e1);

	}
 }
  
 
 
 
 

 class SortNumbersKeepSpecialChars {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("4", "@", "3", "#", "2", "1");

        // Step 1: Extract and sort numeric values
        List<String> sortedNumbers = input.stream()
            .filter(s -> s.matches("\\d+"))
            .sorted(Comparator.comparingInt(Integer::parseInt))
            .collect(Collectors.toList());   

        // Step 2: Rebuild result keeping special characters in place
        Iterator<String> numberIterator = sortedNumbers.iterator();

        List<String> result = input.stream()
            .map(s -> s.matches("\\d+") ? numberIterator.next() : s)
            .collect(Collectors.toList());

        System.out.println("Sorted output: " + result);
    }
}
 
 class SortNumbersKeepSpecials {
	    public static void main(String[] args) {
	        Character[] input = {'5','3','@','&','8','1','!'};

	        // Step 1: Extract only digits and sort them
	        List<Character> sortedDigits = Arrays.stream(input)
	                .filter(Character::isDigit)
	                .sorted()
	                .collect(Collectors.toList());

	        // Step 2: Iterator for sorted digits
	        Iterator<Character> digitIterator = sortedDigits.iterator();

	        // Step 3: Replace digits in original positions with sorted digits
	        Character[] output = Arrays.stream(input)
	                .map(ch -> Character.isDigit(ch) ? digitIterator.next() : ch)
	                .toArray(Character[]::new);

	        // Print result
	        System.out.println(Arrays.toString(output));
	    }
	}
 
 
 class CountAExample2 {
	    public static void main(String[] args) {
	        String[] input = {"ram", "ramalayam", "srikanth"};

	        long count = Arrays.stream(input).mapToLong(s -> s.chars()
	                .filter(ch -> ch == 'a' || ch == 'A')
	                 .count()).sum();

	        System.out.println("Count of 'a': " + count);
	    }
	}
 
 
 class StringPatternStream {
	    public static void main(String[] args) {
	    	
	    	   String s = "AABBDDDDWWUU";
	    	String result = IntStream.range(0, s.length())               // create indices 0..s.length()-1 so we can compare neighbors by index
	    		    .filter(i -> i == 0 || s.charAt(i) != s.charAt(i - 1))   // start of each group (keep only the first index of each repeated block)
	    		    .mapToObj(i -> {                                        
	    		        int count = 1;                                      // we have seen s.charAt(i) once (the group head)
	    		        int j = i + 1;                                      // scanner to count following equal chars
	    		        while (j < s.length() && s.charAt(j) == s.charAt(i)) { // while next char equals the group head
	    		            count++;                                        // increment group count
	    		            j++;                                            // advance scanner
	    		        }
	    		        return count + "" + s.charAt(i);                    // produce "count + character" for this group (e.g. "2A")
	    		    })
	    		    .collect(Collectors.joining());                         // join all group strings into the final compressed string
	    	System.out.println(result);
 
	    }
 }
 
 
 class LongestCommonPrefix {
	    public static void main(String[] args) {
	        String[] input = {"amazon", "amazed", "amaze", "amazing", "amazes"};
	        System.out.println("Longest Common Prefix: " + longestCommonPrefix(input));
	    }

	    public static String longestCommonPrefix(String[] strs) {
	        if (strs == null || strs.length == 0) return "";

	        String prefix = strs[0];
	        for (int i = 1; i < strs.length; i++) {
	            while (strs[i].indexOf(prefix) != 0) {
	                prefix = prefix.substring(0, prefix.length() - 1);
	                if (prefix.isEmpty()) return "";
	            }
	        }
	        return prefix;
	    }
	}
 
 
 class GroupByLength {
	    public static void main(String[] args) {
	        List<String> input = Arrays.asList("a", "bb", "ccc", "dd");

	        Map<Integer, List<String>> grouped = input.stream()
	                .collect(Collectors.groupingBy(String::length));
	        System.out.println(grouped);

	        grouped.forEach((len, group) -> System.out.println(len + " = " + group));
	    }
	}
 
 
 class StringPattern {
	    public static void main(String[] args) {
	        String input = "abbcccddddb";
	        StringBuilder out = new StringBuilder();


	        int idx = 1, count = 1;
	        for (int i = 1; i <= input.length(); i++) {
	            if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
	                count++;
	            } else {
	                out.append(idx++);
	                for (int j = 0; j < count; j++) {
	                    out.append(input.charAt(i - 1));
	                }
	                out.append(count);
	                count = 1;
	            }
	        }

	        System.out.println(out.toString()); // 1a2bb3ccc4dddd5b
	    }
	}
 
 
 
 
 
 class TestOne{
	 public static void main(String[] args) {
		
		  
	
			        List<Object> emp = Arrays.asList(1, "10", 200, "22", 10000, "111", 2000, null);

			        List<String> startWith = emp.stream()
			            .map(obj -> String.valueOf(obj))                   // Convert all objects (including null) to String
			            .filter(e -> e.startsWith("1"))                    // Keep only those starting with "1"
			            .collect(Collectors.toList());                     // Collect into a List

			        System.out.println(startWith);
			    }
	}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
