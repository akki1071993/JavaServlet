package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession userSession = request.getSession(false);
		if (request.isRequestedSessionIdValid()) {

			userSession.removeAttribute("uid");
			userSession.removeAttribute("uname");
			userSession.removeAttribute("umobile");
			userSession.removeAttribute("uemail");
			;
	

			userSession.invalidate();
			if (!request.isRequestedSessionIdValid()) {
				request.getRequestDispatcher("userLogin.html").include(request, response);
				out.print("<header style='color:Green; margin-left:7%'>Successfully Logout ! </header>");
			} else {
				out.print("Your still in login");
			}
		} else {
			request.getRequestDispatcher("home.jsp").include(request, response);
			out.print("<header style='color:red; margin-left:7%'>Please login first ! </header>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
