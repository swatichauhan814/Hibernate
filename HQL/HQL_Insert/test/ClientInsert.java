package test;

import beans.OldStudent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientInsert {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		OldStudent os1 = new OldStudent(111,"swati","swati@gmail.com","hyd");
		OldStudent os2 = new OldStudent(222,"yash","yash@hotmail.com","delhi");
		OldStudent os3 = new OldStudent(333,"gupta","gupta@gmail.com","hyd");
	
		session.save(os1);
		session.save(os2);
		session.save(os3);
		
		transaction.commit();
		session.close();
		sf.close();
	}

}
