package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Flight;
import com.services.AdminServices;
import com.services.UserServices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/UserSearchFlight")
public class UserSearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String departure = request.getParameter("departure");
		String arrival = request.getParameter("arrival");
		// String startDateStr = request.getParameter("date_of_travel");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		List<Flight> flightData = UserServices.searchFlights(departure, arrival);

		if (flightData != null) {

			request.setAttribute("flightData", flightData);
			RequestDispatcher rd = request.getRequestDispatcher("userViewSerchFlight.jsp");
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
