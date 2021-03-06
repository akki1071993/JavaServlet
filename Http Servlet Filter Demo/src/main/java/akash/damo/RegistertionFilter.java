package akash.damo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/RegistertionServlet")
public class RegistertionFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.setContentType("text/html");
		int count = 0;
		String erroMsg = "";
		PrintWriter p = response.getWriter();
		String namePattern = "[a-zA-Z]*";
		String emailPattern = "^(.+)@(.+)$";
		String mobileNoForIndia = "[+91]{3}[0-9]{10}";
		Pattern p1 = Pattern.compile(namePattern);
		Pattern p2 = Pattern.compile(emailPattern);
		Pattern p3 = Pattern.compile(mobileNoForIndia);

		String name = request.getParameter("name");
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");
		String psw = request.getParameter("pass");

		Matcher namematcher = p1.matcher(name);
		Matcher emailmatcher = p2.matcher(email);
		Matcher mobileNomatch = p3.matcher(mobileNo);

		if (namematcher.matches()) {
			count++;
		}
		else {
			erroMsg = "Please enter valid name<br>";
		}
		if (emailmatcher.matches()) {
			count++;
		}
		else {
			erroMsg += "Please enter valid email<br>";
		}
		if (mobileNomatch.matches()) {
			count++;
		}
		else {
			erroMsg += "Please enter valid Mobile No<br>";
		}
		if(psw.length() >= 8) {
			count++;
		}
		else {
			erroMsg += "Password must be 8 digit<br>";
		}

		if (count == 4) {
			chain.doFilter(request, response);
		}
		else {
			p.print("<h1>"+erroMsg+"</h1>");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
