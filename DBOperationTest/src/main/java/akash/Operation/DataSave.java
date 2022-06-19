package akash.Operation;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataSave")
public class DataSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter p = response.getWriter();
		response.setContentType("text/html");

		String name = request.getParameter("pname");
		BigDecimal price = new BigDecimal(request.getParameter("pprice"));

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties props = new Properties();
		props.load(in);
		Connection conn = DBConfig.getConnection(props);
		if (conn != null) {
			try {
				String query = "INSERT INTO eproduct (name,price) VALUES (?,?)";
				PreparedStatement pt = conn.prepareStatement(query);
				pt.setString(1, name);
				pt.setBigDecimal(2, price);

				int x = pt.executeUpdate();

				if (x != 0) {
					response.sendRedirect("ListofProduct");
				} else {
					p.print("Please check your data");
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
