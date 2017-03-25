package test;

import beans.Employee;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_Select_1Column {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
	   String hql = "Select name from Employee";
	
	   Query q = session.createQuery(hql);
		List<String> list = q.list(); //Get entire column
		for(String name : list){
			System.out.println(name);
		}
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
