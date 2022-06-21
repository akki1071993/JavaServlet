package akash.hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname = request.getParameter("sname");
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		PrintWriter p = response.getWriter();
		try {
			Student a = new Student();
			a.setEmail(email);
			a.setName(sname);
			a.setPassword(psw);

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(new Student(sname, email, psw));
			tx.commit();
			session.close();

			p.print("Data Inserted");

		} catch (HibernateException e) {
			p.print(e.getMessage() + "\n" + e.getLocalizedMessage() + "\n" + e.getClass());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
