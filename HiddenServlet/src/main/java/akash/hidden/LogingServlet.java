package akash.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogingServlet
 */
@WebServlet("/LoginServlet")
public class LogingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		String psw = request.getParameter("psw");
		String user = request.getParameter("user");

		if (psw.contentEquals("admin123")) {
			p.print("<form action='DashboardServlet' method='post'>");
			p.print("<input type='hidden' name='name' value='" + user + "'>");
			p.print("<input type='submit' value='DashboardServlet'/>");
		} else {
			p.print("Invalid User name or Password");
			p.print("<a href='index.html'>Login Now</a>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
