package ms;

import java.sql.*;

public class AdvanceJavaProgram2 {

	public static void main(String[] args) {
       try 
       {
    	   Class.forName("oracle.jdbc.driver.OracleDriver");
    	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","root");
    	   Statement stm=con.createStatement();
    	   ResultSet rs=stm.executeQuery("select * from BookDetails68");
    	   while(rs.next()) 
    	   {
    		   System.out.println("BookCode : "+rs.getInt(1)+" "+"BookName : "+rs.getString(2)+" "+"BookAuthor : "+rs.getString(3)+" "+"BookPrice : "+rs.getInt(4)+"Rs"+" "+"Bookqty : "+rs.getInt(5));
    	   }
       }
       catch(Exception e)
       {   
    	  e.printStackTrace(); 
       }
	}
}
