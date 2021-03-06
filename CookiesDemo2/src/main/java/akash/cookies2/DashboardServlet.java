package akash.cookies2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		String user = request.getParameter("user");

		// Create cookie with key value pair
		Cookie cookies = new Cookie("loginCookie", user);
		// Add Cookie in Response
		response.addCookie(cookies);

		p.print("<h1>Welcome to Dashboard " + user + "</h1>");
		p.print("<br><a href='ProfileServlet'>Profile</a>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
