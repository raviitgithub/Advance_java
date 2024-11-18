package StreamAPI;

import java.util.stream.Stream;

public class NamesInLexicographicalOrder {

	public static void main(String[] args) {

		Stream.of("Toby", "Anna", "Leroy", "Alex").filter(name -> name.length() == 4).sorted().limit(2)
				.forEach(System.out::println);

	}

}
