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

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter p = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("pname");
		BigDecimal price = new BigDecimal(request.getParameter("pprice"));

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties proes = new Properties();
		proes.load(in);
		Connection con = DBConfig.getConnection(proes);

		if (con != null) {
			try {
				p.print("Connection");
				PreparedStatement pt = con.prepareStatement("update eproduct set name = ?, price=? where id=?");

				pt.setString(1, name);
				pt.setBigDecimal(2, price);
				pt.setInt(3, id);

				int x = pt.executeUpdate();
				if (x > 0) {
					response.sendRedirect("ListofProduct");
				}else {
					p.print("Please cheak your data");
				}
				

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
