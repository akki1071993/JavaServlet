package akash.URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		String psw = request.getParameter("psw");
		String user = request.getParameter("user");
		if (psw.equals("admin123")) {

			p.print("<h1>Successfully login</h1>");
			p.print("<h2>Welcome:" + user+"</h2>");
			p.print("<a href='DashboardServlet?user=" + user + "'>Click here to access Dashboard</a>");
			
			p.print("<h1><a href = 'DashboardServlet?user="+user+"&name="+psw+"'>Dashbord</a></h1>");

		} else {
			p.print("<h2>Please check User name and Password !</h2>");
			p.print("<h3><a href='index.html'> Login Now</a></h3>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
