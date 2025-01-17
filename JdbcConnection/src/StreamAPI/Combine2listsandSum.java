package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Stream;

//import java.util.List;

public class Combine2listsandSum {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(5, 6, 7, 8);
		List<Integer> list3 = new ArrayList<>();
		list3.addAll(list1);
		list3.addAll(list2);
		int val = list3.stream().reduce((x, y) -> x + y).get();

		System.out.println("Sum of all elements in the combined list:" + val);
	}

}

//Write a Java program that combines two lists of integers into a single list and finds the sum of all elements in the combined list using the Stream API.
//
//Input as : 
// List<Integer> list1 = [1, 2, 3, 4]
// List<Integer> list2 = [5, 6, 7, 8]
//Expected Output:
//Sum of all elements in the combined list: 36