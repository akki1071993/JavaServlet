package akash.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.session.PersistentManager;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/html");

		try {
			Connection conn = DBConfig.getConnection();
			if (conn != null) {
				String fname = request.getParameter("fname");
				String mname = request.getParameter("mname");
				String lname = request.getParameter("lname");
				String gender = request.getParameter("gender");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String uname = request.getParameter("uname");
				String psw = request.getParameter("psw");
				long mobileNo = Long.parseLong(request.getParameter("mobileNo"));

				String query = "insert into user_registration(fname,mname,lname,gender,email,address,uname,psw,mobileNo) values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pt = conn.prepareStatement(query);

				pt.setString(1, fname);
				pt.setString(2, mname);
				pt.setString(3, lname);
				pt.setString(4, gender);
				pt.setString(5, email);
				pt.setString(6, address);
				pt.setString(7, uname);
				pt.setString(8, psw);
				pt.setLong(9, mobileNo);

				

				long x = pt.executeUpdate();
				if (x > 0) {
					p.print("<h1>Data insert Successfully</h1>");
				} else {
					p.print("<h1>Please check your input</h1>");
				}

			}
		} catch (SQLException e) {
			p.print(e);
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
