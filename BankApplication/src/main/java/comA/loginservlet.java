package comA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (username.equals("home") && password.equals("home@123")) {

            response.sendRedirect("home.html");

        } else {

            out.println("<html>");
            out.println("<head><title>Login Failed</title></head>");
            out.println("<body style='font-family:Arial; background:#f2f2f2;'>");

            out.println("<div style='width:350px; margin:120px auto; padding:20px; background:white; text-align:center; border-radius:10px;'>");
            out.println("<h3 style='color:red;'>Incorrect Username or Password</h3>");
            out.println("<a href='login.html'>Try Again</a>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}
