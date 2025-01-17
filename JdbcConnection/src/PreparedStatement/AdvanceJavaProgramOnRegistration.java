package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdvanceJavaProgramOnRegistration {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		try (sc1) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
			PreparedStatement ps1 = con.prepareStatement(
					"insert into User68 (USERNAME, PASSWORD, FIRTNAME,LASTNAME,CITY,EMAILID,PHONENO)VALUES(?,?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from User68 where USERNAME = ? AND PASSWORD = ? ");
			PreparedStatement ps3 = con.prepareStatement(
					"update User68 set CITY=?, EMAILID=?, PHONENO=? where USERNAME = ? AND PASSWORD = ?");
			PreparedStatement ps4 = con.prepareStatement("delete from User68 where USERNAME = ? AND PASSWORD = ? ");
			while (true) {
				System.out.println("========Enter Your Choice===========");
				System.out.println("1.AddUserDetails" + "\n2.ViewUserDetails(based on uname and pword)"
						+ "\n3.UpdateUserDetails(based on uname and pword)(city,mid,phno)"
						+ "\n4.DeleteUserDetails(based on uname and pword)");

				System.out.print("Enter your Choice: ");
				int choice = Integer.parseInt(sc1.nextLine());
				switch (choice) {
				case 1:
					System.out.println("Enter AddUserDetails");
					System.out.print("Enter User Name : ");
					String USERNAME = sc1.nextLine();
					System.out.print("Enter User PASSWORD : ");
					String PASSWORD = sc1.nextLine();

					System.out.print("Enter User FIRTNAME : ");
					String FIRTNAME = sc1.nextLine();
					System.out.print("Enter User LASTNAME : ");
					String LASTNAME = sc1.nextLine();
					System.out.print("Enter User CITY : ");
					String CITY = sc1.nextLine();
					System.out.print("Enter User EMAILID : ");
					String EMAILID = sc1.nextLine();
					System.out.print("Enter User PHONENO : ");
					long PHONENO = Long.parseLong(sc1.nextLine());
					ps1.setString(1, USERNAME);
					ps1.setString(2, PASSWORD);
					ps1.setString(3, FIRTNAME);
					ps1.setString(4, LASTNAME);
					ps1.setString(5, CITY);
					ps1.setString(6, EMAILID);
					ps1.setLong(7, PHONENO);
					int addedd = ps1.executeUpdate();
					if (addedd > 0) {
						System.out.println("Product Added Successfully");
					}
					break;
				case 2:
					System.out.println("ViewUserDetails based on uname and pword");
					System.out.print("Enter User Name : ");
					String USERNAME1 = sc1.nextLine();
					System.out.print("Enter User PASSWORD : ");
					String PASSWORD2 = sc1.nextLine();
					ps2.setString(1, USERNAME1);
					ps2.setString(2, PASSWORD2);
					ResultSet rs = ps2.executeQuery();

					System.out.println("UserDetails ");
					while (rs.next()) {
						System.out.println("FIRTNAME : " + rs.getString(3) + "\t LASTNAME : " + rs.getString(4)
								+ "\t CITY :" + rs.getString(5) + "\t EMAILID : " + rs.getString(6) + "\t PHONENO :"
								+ rs.getLong(7));
					}
					rs.close();
					break;
				case 3:
					System.out.println("UpdateUserDetails(based on uname and pword)(city,mid,phno)");
					System.out.print("Enter User Name : ");
					String USERNAME3 = sc1.nextLine();
					System.out.print("Enter User PASSWORD : ");
					String PASSWORD4 = sc1.nextLine();
					ps2.setString(1, USERNAME3);
					ps2.setString(2, PASSWORD4);

					ResultSet rs2 = ps2.executeQuery();
					if (rs2.next()) {
						System.out.println("CITY :" + rs2.getString(5) + "\t EMAILID : " + rs2.getString(6)
								+ "\t PHONENO :" + rs2.getLong(7));
						System.out.println("Enter city to update : ");
						String CITY1 = sc1.nextLine();
						System.out.println("Enter EMAILID to update : ");
						String EMAILID1 = sc1.nextLine();
						System.out.println("Enter PHONENO to update : ");
						long PHONENO1 = sc1.nextLong();
						ps3.setString(1, CITY1);
						ps3.setString(2, EMAILID1);
						ps3.setLong(3, PHONENO1);
						ps3.setString(4, USERNAME3);
						ps3.setString(5, PASSWORD4);
						int updated = ps3.executeUpdate();
						if (updated > 0) {
							System.out.println("updated successfully");
						} else {
							System.err.println("details not found");
						}
						sc1.nextLine();
					}
					break;
				case 4:
					System.out.println("Deleate UserDetails(based on uname and pword)");
					System.out.print("Enter User Name : ");
					String USERNAME5 = sc1.nextLine();
					System.out.print("Enter User PASSWORD : ");
					String PASSWORD5 = sc1.nextLine();
					ps4.setString(1, USERNAME5);
					ps4.setString(2, PASSWORD5);
					ResultSet rs3 = ps4.executeQuery();
					if (rs3.next()) {
						System.out.println("deleted successfully");
					} else {
						System.err.println("not data found");
					}
					break;
				default:
					System.err.println("Invalid Input");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
