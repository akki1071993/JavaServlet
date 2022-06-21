package akash.DBCreate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DatabaseOperation")
public class DatabaseOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dbname = request.getParameter("dbname");
		PrintWriter p = response.getWriter();

		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties pro = new Properties();
		pro.load(in);
		Connection con = DBConfig.getConnection(pro);
		if (con != null) {
			try {

				Statement st = con.createStatement();
				boolean x = st.execute("CREATE DATABASE " + dbname);

				if (x == false) {
					p.print("Database created successfully !<br>");
					boolean b = st.execute("use " + dbname);
					if (b == false) {
						p.print("Database select successfuly<br>");
						boolean c = st.execute("drop database " + dbname);

						if (c == false) {
							p.print("Database drop Successfully !<br>");
						}
					}
				} else {
					p.print("Please check DB name " + dbname + " DB already in Server");
				}

			} catch (SQLException e) {
				p.print(e);
			} catch (Exception e) {

			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
