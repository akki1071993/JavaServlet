package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Admin;
import com.services.AdminServices;

@WebServlet("/ValidateAdmin")
public class ValidateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Admin admin = new Admin(email, password);

		try {

			boolean isAdminValid = AdminServices.validateAdmin(admin);
			if (isAdminValid) {

				HttpSession session = request.getSession();
				
				session.setAttribute("adminid", admin.getId());
				session.setAttribute("email", admin.getEmail());
				session.setAttribute("password", admin.getPassword());				
				response.sendRedirect("adminHome.jsp");

			} else {
				request.getRequestDispatcher("adminLogin.html").include(request, response);
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
