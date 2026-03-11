package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo4fetch {

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

            String sql = "SELECT * FROM emp";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("ID ,Name ,Age ,Salary ,Designation");
            

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id")+"\t"+ rs.getString("name") +"\t"+ rs.getInt("age") +"\t"+rs.getInt("salary")+"\t" + rs.getString("designation")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
