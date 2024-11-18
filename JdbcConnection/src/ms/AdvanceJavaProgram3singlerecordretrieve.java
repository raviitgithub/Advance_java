package ms;
import java.sql.*;

import java.util.Scanner;

public class AdvanceJavaProgram3singlerecordretrieve {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
try(sc;) 
{
	System.out.print("Enter Account no to get Details : ");
	long accno = sc.nextLong();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
	Statement stm = con.createStatement();
	ResultSet rs = stm.executeQuery("Select * from BankCustomer68 where accno="+accno);
	if(rs.next()) {
		System.out.println("Customer-AccNo : "+rs.getString(1));
		System.out.println("Customer-Name : "+rs.getString(2));
		System.out.println("Customer-Balace : "+rs.getFloat(3));
		System.out.println("Customer-AccType : "+rs.getString(4));
	}
	else {
		System.err.println("Invalid Account Number");
	}
}
catch(Exception e){
	e.printStackTrace();
	
}



	}

}
