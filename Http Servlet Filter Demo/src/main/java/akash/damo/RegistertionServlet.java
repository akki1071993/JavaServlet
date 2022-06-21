package akash.damo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistertionServlet")
public class RegistertionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter p = resp.getWriter();
		
		
		p.print("<h1>Registertion Successfully</h1>");
		p.print("<h2>");
		p.print("<br>Name: "+ req.getParameter("name"));
		p.print("<br>Mobile No: "+ req.getParameter("mobileNo"));
		p.print("<br>Email: "+ req.getParameter("email"));
		p.print("</h2>");
		

	}
}
