package StreamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CountAndPrintOnlyDuplicatesValues {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 1, 6, 7, 3);
		Set<Integer> st = new HashSet<>(numbers); // 1,2,3,4,5,6,7
		Map<Integer, Integer> mp = new HashMap<>();

		st.stream().forEach(x -> {
			mp.put(x, Collections.frequency(numbers, x));
		});

		for (Entry<Integer, Integer> val : mp.entrySet()) {
			if (val.getValue() > 1) {
				System.out.println(val.getKey() + " Count : " + val.getValue());
			}
		}
	}
}

//Write a Java program that takes a list of integers as input, uses the Stream API to find and print all duplicate elements along with their counts.
//Input as : 
//List<Integer> numbers = [1, 2, 3, 4, 2, 5, 1, 6, 7, 3];
//Expected Output:
//Duplicate elements:
//1 (count: 2)
//2 (count: 2)
//3 (count: 2)
