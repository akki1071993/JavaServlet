package akash.cookies2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		Boolean coockie = false;
		Cookie MyCookei = null;
		Cookie ck[] = request.getCookies();
		if (ck != null) {
			for (int i = 0; i < ck.length; i++) {
				MyCookei = ck[i];
				if (MyCookei.getName().contentEquals("loginCookie") && MyCookei.getValue() != null) {
					p.print("<h1>Welcom to Profile Page " + MyCookei.getValue() + "</h1>");
					coockie = true;
				}
			}
		}

		if (coockie == false) {
			p.print("Please login first...!");
			p.print("<br><a href='index.html'>Login Now</a>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
