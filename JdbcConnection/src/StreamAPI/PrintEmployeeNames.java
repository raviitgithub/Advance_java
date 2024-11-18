package StreamAPI;

import java.util.ArrayList;
import java.util.List;

public class PrintEmployeeNames {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee("ram", "165", 120000.22));
		emp.add(new Employee("syam", "195", 13000.00));
		emp.add(new Employee("krim", "135", 192000.22));
		emp.add(new Employee("mam", "115", 120100.22));
		emp.add(new Employee("kaaaam", "175", 19000.22));

		emp.stream().filter(num -> num.salary() > 30000).forEach(e -> System.out.println(e.name().toUpperCase()));

	}

}

record Employee(String name, String id, double salary) {

}
