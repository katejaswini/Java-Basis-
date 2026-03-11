package comA;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/createAccountServlet")
public class CreateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String holdername = request.getParameter("holdername");
        String accountno = request.getParameter("accountno");
        String panno = request.getParameter("panno");
        String aadhaarno = request.getParameter("aadhaarno");
        String phoneno = request.getParameter("phoneno");
        String balance = request.getParameter("balance");
        String accounttype = request.getParameter("accounttype");
        String address = request.getParameter("address");

        try {
            // 1. Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/slksoftware",
                "postgres",
                "slk@SOFT123"
            );

            // 3. SQL Insert Query (column names added)
            String sql = "INSERT INTO bank_account " +
                         "(holdername, accountno, panno, aadhaarno, phoneno, balance, accounttype, address) " +
                         "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, holdername);
            ps.setString(2, accountno);
            ps.setString(3, panno);
            ps.setString(4, aadhaarno);
            ps.setString(5, phoneno);

            long bal = 0;
            if (balance != null && !balance.trim().isEmpty()) {
                bal = Long.parseLong(balance);
            }
            ps.setLong(6, bal);

            ps.setString(7, accounttype);
            ps.setString(8, address);

            // 4. Execute Insert
            ps.executeUpdate();

            ps.close();
            con.close();

            // 5. Redirect back to Home Page
            response.sendRedirect("home.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h2>Account Creation Failed</h2>");
            response.getWriter().println("<p>" + e.getMessage() + "</p>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
