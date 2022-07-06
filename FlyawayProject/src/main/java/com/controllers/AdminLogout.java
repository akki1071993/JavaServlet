package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession(false);
		if (request.isRequestedSessionIdValid()) {
			session.removeAttribute("email");
			session.removeAttribute("adminid");
			session.removeAttribute("password");
			session.invalidate();
			if (!request.isRequestedSessionIdValid()) {
				request.getRequestDispatcher("adminLogin.html").include(request, response);
				out.print("<header style='color:Green; margin-left:7%'>Successfully Logout ! </header>");
			} else {
				out.print("Your still in login");
			}
		} else {
			out.print("<h2>Please login first...!</h2>");
			out.print("<h2>For Login >> <a href='adminLogin.html'> Login</a></h2>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
