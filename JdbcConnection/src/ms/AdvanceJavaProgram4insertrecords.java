package ms;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
//import java.util.*;
public class AdvanceJavaProgram4insertrecords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			System.out.println("=====Read Bank Customer details=====");
			System.out.println("Enter the Customer-AccNo: ");
			long accNo = Long.parseLong(sc.nextLine());
			System.out.println("Enter CUSTNAME : ");
			String CUSTNAME = sc.nextLine();
			System.out.println("Enter BALANCE : ");
        	float BALANCE = Float.parseFloat(sc.nextLine());
            System.out.println("Enter ACCTYPE : ");
			String ACCTYPE = sc.nextLine();
           	Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
            Statement stm = con.createStatement();
            int k = stm.executeUpdate("insert into BankCustomer68 values("+accNo+",'"+CUSTNAME+"',"+BALANCE+",'"+ACCTYPE+"')");
            if(k>0) {
            	System.out.println("Customer details Executed Succefffully");
            }

		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Customer already available....");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
