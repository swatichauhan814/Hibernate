package test;

import beans.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_Update {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		//String hql = "update Student set name = 'gaurav', email='gk@gmail.com'where id=111 "; //Updating name & email
		String hql = "update Student set id=555 where id=111 "; //Updating ONLY id or single column
		Query query = session.createQuery(hql);
		int i = query.executeUpdate();
		System.out.println("Number of rows updated are "+i);
		
		t.commit();
		session.close();
		sf.close();
	}

}
