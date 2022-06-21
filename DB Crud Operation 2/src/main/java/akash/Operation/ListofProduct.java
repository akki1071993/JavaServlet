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

@WebServlet("/ListofProduct")
public class ListofProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties propes = new Properties();
		propes.load(in);
		Connection con = DBConfig.getConnection(propes);
		if (con != null) {
			try {
				PreparedStatement pt = con.prepareStatement("SELECT *FROM eproduct");
				ResultSet r = pt.executeQuery();
				if (r.isBeforeFirst()) {
				
					p.print("<table border= 1 cellpadding=10 cellspacing=0>");
					p.print("<tr><th>No</th><th>Product</th><th>Price</th><th>Date</th><th colspan= 2>Operation</th></tr>");
					while (r.next()) {
						p.print("<tr> ");
						p.print("<th>" + r.getInt(1) + "</th>");
						p.print("<th>" + r.getString(2) + "</th>");
						p.print("<th>" + r.getBigDecimal(3) + "</th>");
						p.print("<th>" + r.getTimestamp(4) + "</th>");
						p.print("<th><a href='Delete?id=" + r.getInt(1) + "'>Delete</a></th>)");
						p.print("<th><a href='UpdatePage?id=" + r.getInt(1) + "'>Update</a></th></tr>");

					}
					p.print("</table>");
					
					p.print("<a href='index.html'>Add Product</a>");
				} else {
					p.print("No Data found !");
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
