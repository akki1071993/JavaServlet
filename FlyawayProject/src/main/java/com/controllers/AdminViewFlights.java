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

import com.dao.Flight;
import com.services.AdminServices;

@WebServlet("/AdminViewFlights")
public class AdminViewFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		List<Flight> flightData = AdminServices.getAllFlights();

		if (flightData != null) {
			request.setAttribute("flightData", flightData);
			RequestDispatcher rd = request.getRequestDispatcher("adminViewFlights.jsp");
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
