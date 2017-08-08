/*Notes:
See line number 27, actually we tried to update Stno(105), we should'nt do this, as we have loaded object from database with his id number only, see line number 23, if we update hibernate will rise an exception
See line number 31 once we call commit(), automatically update method will be called by hibernate.
When ever an object is loaded from database then hibernate stores loaded object in cache-memory maintained by session-interface
Once object is loaded, if we do any modifications on that object by calling its setter methods, then these modification are stored in object maintained by cache-memory
if we modify loaded object for multiple times then also modifications will be stored in object maintained by cache-memory only.
when ever we issue commit() operation then hibernate verify whether any changes are there between object stored in cache and object in database, if 
changes exists then hibernate automatically updates database by generating any update operation. i.e. hibernate automatically maintains synchronization between cache-memory object and database table objects (rows)*/

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class ClientProgram { 
 
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o=session.load(Product.class,new Integer(105));
		Product s=(Product)o;
 
		Transaction tx = session.beginTransaction();	
 
        //s.setStno(105);   should not update, because we loaded with that number right..?
		s.setPrice(4000);   // implicitly update method will be called..
 
		tx.commit();
 
		System.out.println("Object Updated successfully.....!!");
		session.close();
		factory.close();
	}
 
}