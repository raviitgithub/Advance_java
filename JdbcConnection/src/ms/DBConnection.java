package ms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
public static void main(String [] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","root");
		System.out.println("sucess");
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("select * from BankCustomer68");
		
	//	System.out.println(rs);
		while(rs.next()) {
			System.out.println("ACCNO: "+ rs.getInt(1)+" customerName: "+rs.getString(2)+" balance: "+rs.getFloat(3)+rs.getString(4));
			
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
