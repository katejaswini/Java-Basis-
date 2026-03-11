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

public class updatesalaryservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String salary = request.getParameter("salary");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/slksoftware",
                "postgres",
                "slk@SOFT123"
            );

            String sql = "UPDATE emp SET salary = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(salary));
            ps.setInt(2, Integer.parseInt(id));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h2>Salary Updated Successfully</h2>");
            } else {
                out.println("<h2>No Employee Found with ID: " + id + "</h2>");
            }

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
