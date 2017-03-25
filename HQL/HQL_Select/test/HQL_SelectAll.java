package test;

import beans.Employee;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_SelectAll {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
	   String hql = "Select name,email from Employee";
	
	   Query q = session.createQuery(hql);
		List<Employee> list = q.list(); //Get entire multiple columns
		for(Employee emp:list){
			System.out.println("----------------------------");
			System.out.println("Id "+emp.getId());
			System.out.println("Name "+emp.getName());
			System.out.println("Email "+emp.getEmail());
			System.out.println("Salary "+emp.getSalary());
		}
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
