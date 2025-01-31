package Collecctions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentDetails {
	public Map<Integer, String> getStudentDetails(List<String> encryptedList) {
		Map<Integer, String> result = new LinkedHashMap<Integer, String>();
		for (String encrptinfo : encryptedList) {
			int id = 0;
			StringBuffer str =new  StringBuffer();
			for (char ch : encrptinfo.toCharArray()) {
				if (Character.isDigit(ch)) {
					id = id + Character.getNumericValue(ch);
				} else if (Character.isLetter(ch))
				{
				str = str.append(ch);
			}
				

		}
			result.put(id, str.toString());
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> names = List.of( "Ra26j2a6", "A33ru7n8", "R0o87hi2t", "A7n9k2i1t" );
		StudentDetails sd = new StudentDetails();
		Map<Integer, String> res = sd.getStudentDetails(names);
          res.forEach((v,k)->System.out.println("Id:"+v+", Name:"+k));

	}

}
