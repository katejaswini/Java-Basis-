package jdbcdemo1;

import java.sql.*;
import java.util.Scanner;

public class demo5 {

    static void create() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/slksoftware",
                    "postgres",
                    "slk@SOFT123"
            );

            String sql = "INSERT INTO emp (id, name, age, salary, designation) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.print("ID: ");
            ps.setInt(1, sc.nextInt());

            System.out.print("Name: ");
            ps.setString(2, sc.next());

            System.out.print("Age: ");
            ps.setInt(3, sc.nextInt());

            System.out.print("Salary: ");
            ps.setInt(4, sc.nextInt());

            sc.nextLine();
            System.out.print("Designation: ");
            ps.setString(5, sc.nextLine());

            ps.executeUpdate(); 
            System.out.println("inserted");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void display() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/slksoftware",
                    "postgres",
                    "slk@SOFT123"
            );

            String sql = "SELECT * FROM emp";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("ID\tName\tAge\tSalary\tDesignation");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("age") + "\t" +
                        rs.getInt("salary") + "\t" +
                        rs.getString("designation")
                );
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void update() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/slksoftware",
                    "postgres",
                    "slk@SOFT123"
            );

            String sql = "UPDATE emp SET name=?, age=?, salary=?, designation=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Salary: ");
            int salary = sc.nextInt();

            sc.nextLine();
            System.out.print("Designation: ");
            String des = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, salary);
            ps.setString(4, des);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "updated" : "ID not found");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void delete() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/slksoftware",
                    "postgres",
                    "slk@SOFT123"
            );

            String sql = "DELETE FROM emp WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter ID to delete: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "deleted" : "ID not found");

            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Create  2.Display  3.Update  4.Delete  5.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1)
                create();
            else if (ch == 2)
                display();
            else if (ch == 3)
                update();
            else if (ch == 4)
                delete();
            else if (ch == 5) {
                System.out.println("Exited");
                break;  
            } else
                System.out.println("Invalid choice");
        }
    }
}
