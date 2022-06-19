package akash.Operation;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.valueOf(request.getParameter("id"));
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties propes = new Properties();
		propes.load(in);
		Connection con = DBConfig.getConnection(propes);
		if (con != null) {
			try {
				PreparedStatement pt = con.prepareStatement("DELETE from eproduct where id = " + id);
				int x = pt.executeUpdate();
				if (x > 0) {
					response.sendRedirect("ListofProduct");
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
