package jdbcdemo1;//first in pom.xml file load the dependies 
//go to google an type for maven sql dependency or maven postgrle depency copy it and paste in that pom file
//then in the eclipse go --->windows--->preference--->maven---->tick the check boxes

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo1 {

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

            String sql = "INSERT INTO emp (id, name, age, salary, designation) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);

            System.out.print("ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            System.out.print("Designation: ");
            sc.nextLine(); 
            String designation = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setDouble(4, salary);
            ps.setString(5, designation);

            ps.executeUpdate();
            System.out.println("Employee data inserted successfully");

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
