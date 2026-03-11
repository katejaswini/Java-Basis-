package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demoservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String salary = request.getParameter("salary");
        String design = request.getParameter("design");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/slksoftware",
                "postgres",
                "slk@SOFT123"
            );

            String sql = "INSERT INTO emp VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, name);
            ps.setInt(3, Integer.parseInt(age));
            ps.setInt(4, Integer.parseInt(salary));
            ps.setString(5, design);

            ps.executeUpdate();

            out.println("<h2>Data Inserted Successfully</h2>");

            con.close();

        } catch (Exception e) {
            out.println("<h2>Error: " + e + "</h2>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
