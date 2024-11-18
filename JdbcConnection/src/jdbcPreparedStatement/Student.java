package jdbcPreparedStatement;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Scanner;

public class Student {


	public static void main(String[] args) {
        try {
        	Class.forName(DBinfo.driver);
			Connection con = DBinfo.getCon();
			//PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
			PreparedStatement ps1=con.prepareStatement("select * from student", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//Scanner sc =new Scanner(System.in);
//			System.out.println("Enter id :");
//		        String id=sc.nextLine();
//		        System.out.println("Enter your Name :");
//		        String name=sc.nextLine();
//		        System.out.println("Enter your Phoneno :");
//		        String phone=sc.nextLine();
//		        
//		        ps.setString(1, id);
//		        ps.setString(2, name);
//		        ps.setString(3, phone);
//		        int val = ps.executeUpdate();
		        ResultSet rs = ps1.executeQuery();
		        while(rs.next()) {
		        	rs.absolute(2);
		        	System.out.println("id : "+rs.getString(1)+"name : "+rs.getString(2)+"phone : "+rs.getString(3));
		        }
		        } catch (Exception e) {
			e.printStackTrace();
		}
       
	}

}
