package akash.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/welcome")
public class Filter1 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter Initialized 1");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		
		PrintWriter p = response.getWriter();
		p.print("Per Filteration of 1 filter <br> ");
		
		chain.doFilter(request, response);
		
		p.print("Post Filteration of 1 filter ");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter Destroy 1 ");
	}

}
