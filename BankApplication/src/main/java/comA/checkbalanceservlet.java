package comA;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//@WebServlet("/checkbalanceservlet")
public class checkbalanceservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        

        String accountno = request.getParameter("accountno");
        String phoneno = request.getParameter("phoneno");

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/slksoftware",
                "postgres",
                "slk@SOFT123"
            );

            String sql =
                "SELECT balance FROM bank_account WHERE accountno=? AND phoneno=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accountno);
            ps.setString(2, phoneno);

            ResultSet rs = ps.executeQuery();

            response.setContentType("text/html");

            if (rs.next()) {
                long balance = rs.getLong("balance");

                response.getWriter().println(
                    "<h2>Your Current Balance is: ₹" + balance + "</h2>" +
                    "<br><a href='home.html'>Go to Home</a>"
                );
            } else {
                response.getWriter().println(
                    "<h2>Invalid Account Number or Phone Number</h2>"
                );
            }

            rs.close();
            ps.close();
            con.close();
            response.sendRedirect("home.html");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error occurred</h2>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
