package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.User;
import com.services.UserServices;

@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(null, null, email, password);

		try {

			boolean isUserValid = UserServices.validateUser(user);
			if (isUserValid) {

				HttpSession userSession = request.getSession();
				userSession.setAttribute("uid", user.getId());
				userSession.setAttribute("uname", user.getName());
				userSession.setAttribute("umobile", user.getMobile());
				userSession.setAttribute("uemail", user.getEmail());

				response.sendRedirect("userHome.jsp");

			} else {
				request.getRequestDispatcher("userLogin.html").include(request, response);
				out.print("<header style='color:red; margin-left:7%'> Invalid email or password! </header>");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
