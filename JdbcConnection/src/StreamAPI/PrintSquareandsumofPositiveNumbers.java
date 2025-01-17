package StreamAPI;

//import java.util.Collections;
import java.util.stream.Stream;

public class PrintSquareandsumofPositiveNumbers {

	public static void main(String[] args) {

		int sum = Stream.of(-3, 2, -5, 6, -1, 4).filter(n -> n > 0).map(n -> n * n).mapToInt(Integer::intValue).sum();

		System.out.println("Sum of total possitive square : " + sum);
	}

}
