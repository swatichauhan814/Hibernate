/*
Note:
In this program Product.java is just pojo class nothing special
Mapping and Configuration files are just like previous programs
But in ClientProgram.java, see in line number 22 load(-,-) method which is in session, actually we have 2 methods to load object from database, they are load and get.
Now see line number 25,  we are going to print the product name by writing +s.getProName
Actually once we loaded object for the database with load or get methods object data will be loads into the Product.java(POJO) setter methods, so we are printing by using getter methods
*/
import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class ClientProgram { 
 
	public static void main(String[] args)
	{
 
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Object o=session.load(Product.class, new Integer(101));
		Product s=(Product)o;
		// For loading Transaction scope is not necessary...
		System.out.println("Loaded object product name is___"+s.getProName());
 
		System.out.println("Object Loaded successfully.....!!");
		session.close();
		factory.close();
	}
 
}