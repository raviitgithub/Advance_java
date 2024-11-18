package StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//import java.util.stream.Stream;

public class CountEachCharacterInSingleString {

	public static void main(String[] args) {
		String str = "Hello World";
		List<Character> list = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			list.add(ch);
		}
		Set<Character> newSet = new HashSet<>(list);
		Map<Character, Long> mp = new HashMap<>();

		newSet.stream().forEach(x -> {
			mp.put(x, (long) Collections.frequency(list, x));
		});
		mp.forEach((x, y) -> System.out.println("key :" + x + " Value :" + y));
	}

}

//
//Write a Java program that takes a string as input, uses the Stream API to count the occurrences 
// of each character, and stores the result in a Map<Character, Long>.
//
//Input as : 
//Hello World
//Expected Output:
//Character counts:
//h: 1
//e: 1
//l: 3
//o: 2
// : 1
//w: 1
//r: 1
//d: 1
