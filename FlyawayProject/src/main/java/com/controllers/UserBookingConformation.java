package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Admin;
import com.dao.Booking;
import com.services.AdminServices;
import com.services.UserServices;

@WebServlet("/UserBookingConformation")
public class UserBookingConformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession userSession = request.getSession();

		String uname = (String) userSession.getAttribute("uname");
		HttpSession bookFlightSession = request.getSession();

		if (uname != null) {

			int c_id = (Integer) bookFlightSession.getAttribute("c_id");
			int f_id = (Integer) bookFlightSession.getAttribute("f_id");
			Date date_of_travel = (Date) bookFlightSession.getAttribute("date_of_travel");
			int no_of_passenger = (Integer) bookFlightSession.getAttribute("no_of_passenger");
			String type = (String) bookFlightSession.getAttribute("type");
			BigDecimal total_fare = (BigDecimal) (bookFlightSession.getAttribute("total_fare"));


			Booking booking = new Booking(c_id, f_id, date_of_travel, no_of_passenger, type, total_fare);
			boolean isBookFlight = UserServices.bookFlight(booking);

			if (isBookFlight) {

				response.sendRedirect("userBookingConfirmation.jsp");
			}
			
			else {
				
				out.print("Not save");
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
