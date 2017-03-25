package test;

import beans.Employee;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_1Row_Select {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
	   String hql = "from Employee where id=111";
	
	   Query q = session.createQuery(hql);
		Employee emp = (Employee) q.uniqueResult(); //Get single row or object
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getSalary());
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
