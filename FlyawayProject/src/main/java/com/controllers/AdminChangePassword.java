package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.services.AdminServices;

@WebServlet("/AdminChangePassword")
public class AdminChangePassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		int adminid = (Integer) session.getAttribute("adminid");

		String newpassword = request.getParameter("newpassword");

		Boolean isChange = AdminServices.changePassword(adminid, newpassword);
		if (isChange) {
			request.getRequestDispatcher("/AdminLogout").include(request, response);
			out.print("<header style='color:Green; margin-left:7%'>Successfully Change Password ! </header>");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
