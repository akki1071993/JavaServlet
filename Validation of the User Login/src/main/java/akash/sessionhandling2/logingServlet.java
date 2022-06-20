package akash.sessionhandling2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logingServlet")
public class logingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");

		String user = request.getParameter("user");
		String psw = request.getParameter("psw");

		if (psw.contentEquals("admin123")) {			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("DashboardServlet");
		}
		else {
			p.print("<h2>Please Check User Name and Password...!</h2>");
			p.print("<h2>For Login >> <a href='index.html'> Login</a></h2>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
