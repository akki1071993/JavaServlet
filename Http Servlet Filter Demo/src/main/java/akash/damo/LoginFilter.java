package akash.damo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/login")
public class LoginFilter extends HttpFilter implements Filter {
    
	private static final long serialVersionUID = 1L;


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		
		String email = request.getParameter("email");
		String psw = request.getParameter("pass");
		
		if(email.equals("akash@gmail.com") && psw.equals("admin@123")) {
			chain.doFilter(request, response);
		}
		else {
			p.print("<h2>Please enter valide Id and Password</h2>");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
