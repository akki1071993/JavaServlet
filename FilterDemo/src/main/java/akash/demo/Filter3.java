package akash.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/welcome")
public class Filter3 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter p = response.getWriter();
		p.print("Per Filteration of 3 filter <br> ");
		
		chain.doFilter(request, response);
		
		p.print("Post Filteration oxf 3 filter <br> ");
	}

}
