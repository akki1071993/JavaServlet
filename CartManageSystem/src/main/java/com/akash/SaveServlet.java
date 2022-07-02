package com.akash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		
		 List<product> list = new ArrayList<product>();
		
		product p = new product();
		p.setPid(pid);
		p.setPname(pname);
		p.setPprice(pprice);
		
		product p1 = new product();
		p1.setPid(2);
		p1.setPname("LALA");
		p1.setPprice("2500");
		
		list.add(p);
		list.add(p1);
		HttpSession session = request.getSession();
		session.setAttribute("productList", list);
		response.sendRedirect("success.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
