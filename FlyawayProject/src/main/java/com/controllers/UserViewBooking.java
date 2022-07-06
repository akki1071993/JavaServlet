package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Booking;
import com.services.AdminServices;
import com.services.UserServices;

@WebServlet("/UserViewBooking")
public class UserViewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession userSession = request.getSession();
		int id = (Integer) userSession.getAttribute("uid");		

		List<Booking> userBookingDate = UserServices.getBookingByUserId(id);

		if (userBookingDate != null) {			

			request.setAttribute("userbookingDate", userBookingDate);
			RequestDispatcher rd = request.getRequestDispatcher("userViewBooking.jsp");
			rd.forward(request, response);
		} else {
			out.print("Data not found");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
