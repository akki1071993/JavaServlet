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

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		User user = new User(name, mobile, email, password);
		out.print(name + " " + email + " " + mobile + " " + password);

		boolean saveUser = UserServices.saveUser(user);
		if (saveUser) {

			HttpSession userSession = request.getSession();
			userSession.setAttribute("id", user.getId());
			userSession.setAttribute("name", user.getName());
			userSession.setAttribute("mobile", user.getMobile());
			userSession.setAttribute("email", user.getEmail());

			response.sendRedirect("userHome.jsp");
		}
		else {
			request.getRequestDispatcher("userRegister.html").include(request, response);
			out.print("<header style='color:red; margin-left:7%'>Somthing is worng Please try Again! </header>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
