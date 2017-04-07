package test;

import beans.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_Delete {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		String hql = "delete Student where id=2 "; //Updating ONLY id or single column
		Query query = session.createQuery(hql);
		int i = query.executeUpdate();
		System.out.println("Number of rows deleted are "+i);
		
		t.commit();
		session.close();
		sf.close();
	}

}
