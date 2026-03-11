package comA;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//@WebServlet("/withdrawservlet")
public class withdrawservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountno = request.getParameter("accountno");
        String phoneno = request.getParameter("phoneno");
        long amount = Long.parseLong(request.getParameter("amount"));

        if (amount <= 0) {
            response.getWriter().println("<h2>Invalid Withdraw Amount</h2>");
            return;
        }

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/slksoftware",
                "postgres",
                "slk@SOFT123"
            );

            // 1️⃣ Check account & balance
            String checkSql =
                "SELECT balance FROM bank_account WHERE accountno=? AND phoneno=?";
            PreparedStatement ps1 = con.prepareStatement(checkSql);
            ps1.setString(1, accountno);
            ps1.setString(2, phoneno);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                long currentBalance = rs.getLong("balance");

                if (currentBalance < amount) {
                    response.getWriter().println("<h2>Insufficient Balance</h2>");
                    return;
                }

                long newBalance = currentBalance - amount;

                // 2️⃣ Update balance
                String updateSql =
                    "UPDATE bank_account SET balance=? WHERE accountno=?";
                PreparedStatement ps2 = con.prepareStatement(updateSql);
                ps2.setLong(1, newBalance);
                ps2.setString(2, accountno);

                ps2.executeUpdate();

                ps2.close();
                ps1.close();
                con.close();

                response.sendRedirect("\"<br><a href='home.html'>Go to Home</a>\"");

            } else {
                response.getWriter()
                        .println("<h2>Invalid Account Number or Phone Number</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error Occurred</h2>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
