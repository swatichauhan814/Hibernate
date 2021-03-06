package test;

import beans.Employee;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_Select_2Columns {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
	   String hql = "Select name,email from Employee";
	
	   Query q = session.createQuery(hql);
		List<Object> list = q.list(); //Get entire multiple columns
		for(Object o : list){
			Object ar[] = (Object[])o;
			System.out.println(ar[0]);
			System.out.println(ar[1]);
		}
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
