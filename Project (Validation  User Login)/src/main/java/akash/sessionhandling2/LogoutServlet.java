package akash.sessionhandling2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		if (request.isRequestedSessionIdValid()) {
			session.removeAttribute("user");
			session.invalidate();
			
			if (!request.isRequestedSessionIdValid()) {

				p.print("<h2>Logout Successfully</h2>");
				p.print("<h2>For Login >> <a href='index.html'> Login</a></h2>");
			} else {
				p.print("Your still in login");
			}
		} else {
			p.print("<h2>Please login first...!</h2>");
			p.print("<h2>For Login >> <a href='index.html'> Login</a></h2>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
