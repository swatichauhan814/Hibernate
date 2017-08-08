/* Note:
To delete object( 1 row) form database we need to call delete method in session.
In hibernate we have only one method to delete an object from the database.
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
 
        Object o=session.load(Product.class,new Integer(103));
        Product p=(Product)o;
 
        Transaction tx = session.beginTransaction();
        session.delete(p);
        System.out.println("Object Deleted successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
    }
 
}