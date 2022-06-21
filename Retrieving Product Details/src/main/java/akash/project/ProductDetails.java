package akash.project;

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

@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("pid"));
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties propes = new Properties();
		propes.load(in);
		Connection con = DBConfig.getConnection(propes);
		if (con != null) {
			try {
				PreparedStatement pt = con.prepareStatement("select *from eproduct where id = ?");
				pt.setInt(1, id);
				ResultSet rs = pt.executeQuery();
				if (rs.isBeforeFirst()) {

					p.print("<h2>Product Details</h2><table border= 1 cellpadding=10 cellspacing=0>");
					while (rs.next()) {
						p.print("<tr><th>Product Name:</th><th>" + rs.getString(2) + "</th></tr>");
						p.print("<tr><th>Price: </th><th>" + rs.getString(3) + "</th></tr>");
					}
				
					p.print("<tr><th colspan='2'> <a href='index.html'>Back to Home</a></th></tr></table>");
				
				}
				else {
					p.print("<h2>Data No Found !</h2>");
				}
			}

			catch (Exception e) {
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
