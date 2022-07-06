package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.services.UserServices;

@WebServlet("/UserChangePassword")
public class UserChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession userSession = request.getSession();
		int userid = (Integer) userSession.getAttribute("uid");
		String newpassword = request.getParameter("newpassword");

		Boolean isChange = UserServices.changePassword(userid, newpassword);
		if (isChange) {
			request.getRequestDispatcher("/UserLogout").include(request, response);
			out.print("<header style='color:Green; margin-left:7%'>Successfully Change Password ! </header>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
