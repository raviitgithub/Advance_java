package StreamAPI;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

public class findMinandMaxValues {

	public static void main(String[] args) {
		int[] numbers = { 5, 12, 3, 8, 1, 9, 6 };

		List<Integer> list = Arrays.stream(numbers).boxed().toList();
		if (list.isEmpty()) {
			throw new RuntimeException("Array is empty");
		} else {
			int max = list.stream().max(Comparator.naturalOrder()).get();
			int min = list.stream().min(Comparator.naturalOrder()).get();
			System.out.println("min value :" + min + "   " + "max value :" + max);
		}
// List<Integer> newList =list.stream().sorted().collect(Collectors.toList());
//	System.out.println(newList);

	}

}

//	
//	Write a Java program that finds and prints the maximum and minimum values from an array of integers using the Stream API. If the array is empty, throw a RuntimeException.
//
//	Test Cases:
//
//	Test case 1 : Basic Case - Standard Array:
//	Input: {5, 12, 3, 8, 1, 9, 6}
//	Expected Output:
//	Maximum value: 12
//	Minimum value: 1
