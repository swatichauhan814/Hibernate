package test;

import beans.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Student st = new Student(111,"swati","swati@gmail.com");
		
		session.save(st);
		
		t.commit();
		session.close();
		sf.close();
		
		System.out.println("Saved Successfully!!");
	}

}
