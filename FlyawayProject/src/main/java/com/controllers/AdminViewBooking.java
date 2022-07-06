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
import com.dao.Booking;
import com.services.AdminServices;

@WebServlet("/AdminViewBooking")
public class AdminViewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		List<Booking> bookingDate = AdminServices.getAllBooking();

		if (bookingDate != null) {

			request.setAttribute("bookingDate", bookingDate);
			RequestDispatcher rd = request.getRequestDispatcher("adminViewBooking.jsp");
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
