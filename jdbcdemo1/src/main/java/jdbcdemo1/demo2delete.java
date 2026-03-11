package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class demo2delete {

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

            String sql = "DELETE FROM emp WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee record deleted successfully");
            } else {
                System.out.println("No employee found with this ID");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

