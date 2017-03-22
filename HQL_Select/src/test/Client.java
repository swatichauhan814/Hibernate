package test;

import beans.Employee;

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
		Transaction transaction = session.beginTransaction();
		
		Employee emp1 = new Employee(111,"swati","swati@gmail.com",24000);
		Employee emp2 = new Employee(222,"yash","yash@gmail.com",63000);
		Employee emp3 = new Employee(333,"gaurav","gaurav@gmail.com",50000);
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
