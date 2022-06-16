package akash.hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DashboardServlet")
public class DeshboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		PrintWriter p = response.getWriter();
   		response.setContentType("text/html");
   		
   		String name = request.getParameter("name");
   		if(name !=null) {
   			p.print("<h1>Welcome to Dashboard "+name+"</h1>");
   		}
   		else {
   			p.print("<h2>Please login first...!</h2>");
   			p.print("<a href='index.html'>Login Now</a>");
   		}
   	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
