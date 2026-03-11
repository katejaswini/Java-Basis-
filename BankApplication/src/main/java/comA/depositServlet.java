package comA;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/depositServlet")
public class depositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountno = request.getParameter("accountno");
        String phoneno = request.getParameter("phoneno");
        long amount = Long.parseLong(request.getParameter("amount"));

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/slksoftware",
                "postgres",
                "slk@SOFT123"
            );

            String checkSql =
                "SELECT balance FROM bank_account WHERE accountno=? AND phoneno=?";
            PreparedStatement ps1 = con.prepareStatement(checkSql);
            ps1.setString(1, accountno);
            ps1.setString(2, phoneno);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                long currentBalance = rs.getLong("balance");
                long newBalance = currentBalance + amount;

                String updateSql =
                    "UPDATE bank_account SET balance=? WHERE accountno=?";
                PreparedStatement ps2 = con.prepareStatement(updateSql);
                ps2.setLong(1, newBalance);
                ps2.setString(2, accountno);

                ps2.executeUpdate();

                ps2.close();
                ps1.close();
                con.close();

                response.sendRedirect("home.html");

            } else {
                response.setContentType("text/html");
                response.getWriter()
                        .println("<h2>Invalid Account Number or Phone Number</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
