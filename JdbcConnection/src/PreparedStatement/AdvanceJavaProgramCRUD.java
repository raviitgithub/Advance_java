package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdvanceJavaProgramCRUD {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");

			PreparedStatement ps1 = con
					.prepareStatement("INSERT INTO Product68 (CODE, NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)");
			PreparedStatement ps2 = con.prepareStatement("SELECT * FROM Product68");
			PreparedStatement ps3 = con.prepareStatement("SELECT * FROM Product68 WHERE CODE = ?");
			PreparedStatement ps4 = con.prepareStatement("UPDATE Product68 SET PRICE = ?, QUANTITY =QUANTITY + ? WHERE CODE = ?");
			PreparedStatement ps5 = con.prepareStatement("DELETE FROM Product68 WHERE CODE = ?");

			while (true) {
				System.out.println("=====Enter your choice======");
				System.out.println("\t1. Add Product" + "\n\t2. View All Products" + "\n\t3. View Product By Code"
						+ "\n\t4. Update Product By Code (price-qty)" + "\n\t5. Delete Product By Code"
						+ "\n\t6. Exit");

				System.out.print("Enter your Choice: ");
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1: // Add Product
					System.out.println("=====Insert Product Details========");

					System.out.print("Enter Product CODE: ");
					String code = sc.nextLine();
					System.out.print("Enter Product NAME: ");
					String name = sc.nextLine();
					System.out.print("Enter Product PRICE: ");
					float price = Float.parseFloat(sc.nextLine());
					System.out.print("Enter Product QUANTITY: ");
					int quantity = Integer.parseInt(sc.nextLine());

					ps1.setString(1, code);
					ps1.setString(2, name);
					ps1.setFloat(3, price);
					ps1.setInt(4, quantity);

					int added = ps1.executeUpdate();
					if (added > 0) {
						System.out.println("Product Added Successfully");
					}
					break;

				case 2: // View All Products
					ResultSet rs = ps2.executeQuery();
					System.out.println("=======Product Details=======");
					while (rs.next()) {
						System.out.println(
								rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getInt(4));
					}
					rs.close();
					break;

				case 3: // View Product By Code
					System.out.print("Enter Product CODE: ");
					String cd = sc.nextLine();
					ps3.setString(1, cd);

					ResultSet rs1 = ps3.executeQuery();
					System.out.println("=======Product Details=======");
					if (rs1.next()) {
						System.out.println(rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getFloat(3) + "\t"
								+ rs1.getInt(4));
					} else {
						System.out.println("Product not found.");
					}
					rs1.close();
					break;

				case 4: // Update Product By Code
					System.out.print("Enter Product CODE: ");
					String updateCode = sc.nextLine();

					// Retrieve and display the current price and quantity for the specified product
					// code
					ps3.setString(1, updateCode);
					ResultSet rsCheck = ps3.executeQuery();

					if (rsCheck.next()) {
						System.out.println("Current Product Details:");
						System.out.println(
								"Price: " + rsCheck.getFloat("PRICE") + ", Quantity: " + rsCheck.getInt("QUANTITY"));

						System.out.print("Enter Updated Product PRICE: ");
						float updatePrice = Float.parseFloat(sc.nextLine());
						System.out.print("Enter Updated Product QUANTITY: ");
						int updateQuantity = Integer.parseInt(sc.nextLine());

						ps4.setFloat(1, updatePrice);
						ps4.setInt(2, updateQuantity);
						ps4.setString(3, updateCode);      

						int updated = ps4.executeUpdate();
						if (updated > 0) {
							System.out.println("Product Updated Successfully");
						} else {
							System.out.println("Product not found.");
						}
					} else {
						System.out.println("Product not found.");
					}

					rsCheck.close();
					break;

				case 5: // Delete Product By Code
					System.out.print("Enter Product CODE: ");
					String deleteCode = sc.nextLine();

					ps5.setString(1, deleteCode);

					int deleted = ps5.executeUpdate();
					if (deleted > 0) {
						System.out.println("Product Deleted Successfully");
					} else {
						System.out.println("Product not found.");
					}
					break;

				case 6: // Exit
					System.out.println("Operation Stopped.");
					System.exit(0);

				default:
					System.out.println("Invalid Choice");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








