package akash.hibernate.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AppTest {

	public static void main(String[] args) {
		Student akash = new Student();
		akash.setRollNo(105);
		akash.setName("Rushabh Mahant");
		akash.setGender("Male");

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(akash);
		tx.commit();

	

		tx.commit();

	}
}
