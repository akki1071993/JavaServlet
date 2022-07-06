package com.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Flight;
import com.services.UserServices;

@WebServlet("/UserBooking")
public class UserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession userSession = request.getSession();
		String uemail = (String) userSession.getAttribute("uemail");
		if (uemail != null) {
			
			response.setContentType("text/html");

			int id = Integer.parseInt(request.getParameter("f_id"));

			List<Flight> flightData = new ArrayList<Flight>();
			flightData = UserServices.getFlightById(id);
			Flight selectFlight = new Flight();
			for (Flight flight : flightData) {

				selectFlight.setF_id(flight.getF_id());
				selectFlight.setF_code(flight.getF_code());
				selectFlight.setAirline(flight.getAirline());
				selectFlight.setDeparture(flight.getDeparture());
				selectFlight.setArrival(flight.getArrival());
				selectFlight.setBusiness_fare(flight.getBusiness_fare());
				selectFlight.setEconomic_fare(flight.getEconomic_fare());
				selectFlight.setPrime_fare(flight.getPrime_fare());

			}

			if (selectFlight != null) {
				HttpSession selectFlightSession = request.getSession();
				selectFlightSession.setAttribute("f_id", selectFlight.getF_id());
				selectFlightSession.setAttribute("f_code", selectFlight.getF_code());
				selectFlightSession.setAttribute("airline", selectFlight.getAirline());
				selectFlightSession.setAttribute("departure", selectFlight.getDeparture());
				selectFlightSession.setAttribute("arrival", selectFlight.getArrival());
				selectFlightSession.setAttribute("business_fare", selectFlight.getBusiness_fare());
				selectFlightSession.setAttribute("economic_fare", selectFlight.getEconomic_fare());
				selectFlightSession.setAttribute("prime_fare", selectFlight.getPrime_fare());

				response.sendRedirect("userBooking.jsp");
			}
		}
		else {
			response.sendRedirect("userLogin.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
