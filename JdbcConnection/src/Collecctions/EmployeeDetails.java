package Collecctions;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeDetails {
	public Map<Character, Character> getEmpDetails(String[] array) {
		Map<Character, Character> res = new LinkedHashMap<Character, Character>();

		for (String str : array) {
			int start = 0;
			int end = str.length() - 1;
			res.put(str.charAt(start), str.charAt(end));

		}

		return res;

	}

	public static void main(String[] args) {
		String[] names = { "Ram", "Murli", "Rohit", "Mayank", "Lalit" };
		EmployeeDetails ed = new EmployeeDetails();
		Map<Character, Character> result = ed.getEmpDetails(names);

		System.out.println(result);

	}

}
