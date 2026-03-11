package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class demo3update {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/slksoftware",
                    "postgres",
                    "slk@SOFT123"
            );
            System.out.println("Connection created");

            String sql = "UPDATE emp SET name = ?, age = ?, salary = ?, designation = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();

            System.out.print("Enter New Name: ");
            String name = sc.next();

            System.out.print("Enter New Age: ");
            int age = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            sc.nextLine(); // clear buffer
            System.out.print("Enter New Designation: ");
            String designation = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, salary);
            ps.setString(4, designation);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee record updated successfully");
            } else {
                System.out.println("Employee ID not found");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
