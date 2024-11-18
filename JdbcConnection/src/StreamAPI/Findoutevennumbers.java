package StreamAPI;

//import java.util.*;
import java.util.stream.Stream;

public class Findoutevennumbers {
public static void main(String[] args) {
			Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.filter(num ->num%2==0)
			.forEach(System.out::println); 
				
			}
}



//Write a Java program that creates a stream of integers using Stream.of, filters out the even numbers and then prints each squared number using forEach.
//Input (Stream):
//1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//Output:
//2
//4
//6
//8
//10