package akash.Operation;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePage")
public class UpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.valueOf(request.getParameter("id"));
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties proes = new Properties();
		proes.load(in);
		Connection con = DBConfig.getConnection(proes);
		if (con != null) {
			try {
				PreparedStatement pt = con.prepareStatement("Select * from eproduct where id = " + id + "");
				ResultSet rs = pt.executeQuery();
				if (rs.isBeforeFirst()) {
					while (rs.next()) {
						
						p.print("<h1>User update Page</h1>");
						p.print("<form action='UpdateData' method='post'>");
						p.print("<table border= '1' cellpadding='10' cellspacing=0>");
						p.print("<input type='hidden' name='id'  value='" + rs.getInt(1) + "'>");
						p.print("<tr><th>Product Name: </th><th><input type='text' name='pname' value='"
								+ rs.getString(2) + "'></th></tr>");
						p.print("<tr><th>Price: </th><th><input type='text' name='pprice' value='" + rs.getBigDecimal(3)
								+ "'></th></tr>");
						p.print("<tr><th colspan='2'><input type='submit' value='Update' ></th></tr>");
						p.print("</table></form>");
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
