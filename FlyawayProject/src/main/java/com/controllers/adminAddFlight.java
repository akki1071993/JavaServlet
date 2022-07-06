package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Flight;
import com.services.AdminServices;

@WebServlet("/adminAddFlight")
public class adminAddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		Flight flightData = new Flight();
		String weekdays = new String();

		flightData.setF_code((String) request.getParameter("f_code"));
		flightData.setAirline((String) request.getParameter("airline"));
		flightData.setArrival((String) request.getParameter("to"));
		flightData.setDeparture((String) request.getParameter("from"));
		flightData.setBusiness_fare(new BigDecimal(request.getParameter("business_fare")));
		flightData.setEconomic_fare(new BigDecimal(request.getParameter("economic_fare")));
		flightData.setPrime_fare(new BigDecimal(request.getParameter("economic_fare")));
		String days[] = request.getParameterValues("weekdays");
		for (int i = 0; i < days.length; i++) {
			weekdays += days[i];

			if (i < days.length - 1) {
				weekdays += "_";
			}
		}
		flightData.setWeekdays(weekdays);
		
		Boolean saveFlight = AdminServices.saveFlight(flightData);
		if (saveFlight) {
			out.print("<header style='color:green; margin-left:7%'> Flight save successfully ! </header>");
			request.getRequestDispatcher("adminAddFlight.jsp").include(request, response);
			
		} else {
			request.getRequestDispatcher("adminAddFlight.jsp").include(request, response);
			out.print("<header style='color:red; margin-left:7%'> Flight not save ! </header>");
		}
		{

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
