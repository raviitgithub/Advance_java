package StreamAPI;

//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcateStringbySkipspaces {

	public static void main(String[] args) {

		String st = Stream.of("Hello", "", "World", " ", "from", " ", "Java", "!").filter(str -> !(str.isBlank()))
				.collect(Collectors.joining());
		System.out.println(st);

	}

}
//Write a Java program that uses the Stream.of method to create a stream of strings, filters out the empty strings, and then concatenate the remaining strings into a single string..
//
//Input:
//A stream of strings ["Hello", "", "World", " ", "from", " ", "Java", "!"].
//
//Output:
//A single concatenated string:
//HelloWorld from Java!

//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Main {
//    public static void main(String[] args) {
//        String result = Stream.of("Hello", "", "World", " ", "from", " ", "Java", "!")
//            .filter(s -> !s.trim().isEmpty())         // Filters out empty or whitespace-only strings
//            .collect(Collectors.joining());           // Concatenates remaining strings
//
//        System.out.println(result);                   // Prints the concatenated result
//    }
//}
