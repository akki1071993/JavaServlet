package akash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WelcomeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		out.print("Hello this is Servlet");
		
		
		PrintWriter out1 = res.getWriter();
		out.print("\nHello this is Servlet 2");
		
		
	}

	
	
	
}
