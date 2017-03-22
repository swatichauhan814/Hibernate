package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_Aggregate {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
	   String hql = "Select avg(salary) from Employee";
	
	   Query q = session.createQuery(hql);
		double avg =(Double) q.uniqueResult();
	  
		System.out.println("Average Salary : " +avg);
		transaction.commit();
		session.close();
		sf.close();
	}
}
