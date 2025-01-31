package StreamAPI;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Stream;

public class StudentEnrolled {
	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		list.add(new Student("Bob", "java"));
		list.add(new Student("Alice", "Python"));
		list.add(new Student("Bob", "Python"));
		list.add(new Student("Charlie", "java"));
		list.add(new Student("David", "C++"));
		list.add(new Student("Eve", "java"));
		System.out.println("===Lembda Expression=========");
		list.stream().filter(s -> s.cource().equalsIgnoreCase("Java")).forEach(n -> System.out.println(n.name()));
		System.out.println("=====Method Reference========");
		list.stream().filter(s -> s.cource().equalsIgnoreCase("Java")).forEach(System.out::println);

	}

}

record Student(String name, String cource) {

}