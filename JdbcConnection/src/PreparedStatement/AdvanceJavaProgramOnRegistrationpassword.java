package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdvanceJavaProgramOnRegistrationpassword {
	public static boolean checkValidPassword(String password) {
		if (password.length() < 8) {
			System.err.println("Password must be at least 8 characters.");
			return false;
		}
		boolean hasUppercase = false;
		boolean hasLowercase = false;
		boolean hasDigit = false;
		boolean hasSpecialCharacter = false;
		String specialCharacters = "!@#$%&*";

		for (char ch : password.toCharArray()) {
			if (Character.isUpperCase(ch))
				hasUppercase = true;
			else if (Character.isLowerCase(ch))
				hasLowercase = true;
			else if (Character.isDigit(ch))
				hasDigit = true;
			else if (specialCharacters.contains(String.valueOf(ch)))
				hasSpecialCharacter = true;
		}

		if (!hasUppercase || !hasLowercase || !hasDigit || !hasSpecialCharacter) {
			System.err.println(
					"Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		try (Scanner sc1 = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
						"root")) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			PreparedStatement ps1 = con.prepareStatement(
					"INSERT INTO User68 (USERNAME, PASSWORD, FIRTNAME, LASTNAME, CITY, EMAILID, PHONENO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			PreparedStatement ps2 = con.prepareStatement("SELECT * FROM User68 WHERE USERNAME = ? AND PASSWORD = ?");
			PreparedStatement ps3 = con.prepareStatement(
					"UPDATE User68 SET CITY = ?, EMAILID = ?, PHONENO = ? WHERE USERNAME = ? AND PASSWORD = ?");
			PreparedStatement ps4 = con.prepareStatement("DELETE FROM User68 WHERE USERNAME = ? AND PASSWORD = ?");

			while (true) {
				System.out.println("======== Enter Your Choice ==========");
				System.out.println("1. Add User Details" + "\n2. View User Details (by username and password)"
						+ "\n3. Update User Details (city, email, phone)"
						+ "\n4. Delete User Details (by username and password)");

				System.out.print("Enter your choice: ");
				int choice = Integer.parseInt(sc1.nextLine());

				switch (choice) {
				case 1:
					System.out.print("Enter Username: ");
					String username = sc1.nextLine();
					System.out.print("Enter Password: ");
					String password = sc1.nextLine();

					if (!checkValidPassword(password))
						break;

					System.out.print("Enter First Name: ");
					String firstName = sc1.nextLine();
					System.out.print("Enter Last Name: ");
					String lastName = sc1.nextLine();
					System.out.print("Enter City: ");
					String city = sc1.nextLine();
					System.out.print("Enter Email ID: ");
					String emailId = sc1.nextLine();
					System.out.print("Enter Phone Number: ");
					long phoneNo = Long.parseLong(sc1.nextLine());

					ps1.setString(1, username);
					ps1.setString(2, password);
					ps1.setString(3, firstName);
					ps1.setString(4, lastName);
					ps1.setString(5, city);
					ps1.setString(6, emailId);
					ps1.setLong(7, phoneNo);

					int added = ps1.executeUpdate();
					System.out.println(added > 0 ? "User added successfully." : "User addition failed.");
					break;

				case 2:
					System.out.print("Enter Username: ");
					String unameView = sc1.nextLine();
					System.out.print("Enter Password: ");
					String pwdView = sc1.nextLine();

					ps2.setString(1, unameView);
					ps2.setString(2, pwdView);
					ResultSet rs = ps2.executeQuery();

					if (rs.next()) {
						System.out.println("User Details:");
						System.out.printf("First Name: %s, Last Name: %s, City: %s, Email ID: %s, Phone: %d%n",
								rs.getString("FIRTNAME"), rs.getString("LASTNAME"), rs.getString("CITY"),
								rs.getString("EMAILID"), rs.getLong("PHONENO"));
					} else {
						System.err.println("User not found.");
					}
					rs.close();
					break;

				case 3:
					System.out.print("Enter Username: ");
					String unameUpdate = sc1.nextLine();
					System.out.print("Enter Password: ");
					String pwdUpdate = sc1.nextLine();

					ps2.setString(1, unameUpdate);
					ps2.setString(2, pwdUpdate);
					ResultSet rs2 = ps2.executeQuery();

					if (rs2.next()) {
						System.out.print("Enter new City: ");
						String newCity = sc1.nextLine();
						System.out.print("Enter new Email ID: ");
						String newEmail = sc1.nextLine();
						System.out.print("Enter new Phone Number: ");
						long newPhone = Long.parseLong(sc1.nextLine());

						ps3.setString(1, newCity);
						ps3.setString(2, newEmail);
						ps3.setLong(3, newPhone);
						ps3.setString(4, unameUpdate);
						ps3.setString(5, pwdUpdate);

						int updated = ps3.executeUpdate();
						System.out.println(updated > 0 ? "User updated successfully." : "Update failed.");
					} else {
						System.err.println("User not found.");
					}
					rs2.close();
					break;

				case 4:
					System.out.print("Enter Username: ");
					String unameDelete = sc1.nextLine();
					System.out.print("Enter Password: ");
					String pwdDelete = sc1.nextLine();

					ps4.setString(1, unameDelete);
					ps4.setString(2, pwdDelete);
					int deleted = ps4.executeUpdate();

					System.out.println(deleted > 0 ? "User deleted successfully." : "User not found.");
					break;

				default:
					System.err.println("Invalid input. Please try again.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
