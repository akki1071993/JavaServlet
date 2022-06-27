package akash.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class main {

	public static void main(String[] args) {

		StandardServiceRegistry registery = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata metadata = new MetadataSources(registery).getMetadataBuilder().build();
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Student s1 = new Student("Puya", "hiyu@gmail.com", "852@wer");
		session.save(s1);

		tx.commit();

		System.out.println("Data Inserted Successfully");

	}

}
