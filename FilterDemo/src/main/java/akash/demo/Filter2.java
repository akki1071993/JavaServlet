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
import javax.servlet.http.HttpFilter;

@WebFilter("/welcome")
public class Filter2 extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Initialized 2");
	}

	public void destroy() {
		System.out.println("Filter Destroy 2");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		p.print("Per Filteration of 2 filter <br> ");
		chain.doFilter(request, response);
		p.print("Post Filteration of 2 filter <br> ");
	}

}
