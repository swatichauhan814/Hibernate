/* Program to update object (1 complete row) in database, which is already persisted in database, then we have following 2 approaches…

Approach 1
Load that object from database, and modify its values, now hibernate automatically modifies values on to database also, when ever the transaction is committed.

Approach 2:
If we want to modify object in database, then create new object with same id and we must call update() given by session interface.
Files required to execute this program..
Product.java (My POJO class)
product.hbm.xml (Xml mapping file )
hibernate.cfg.xml (Xml configuration file)
ClientProgram.java(java file to write our hibernate logic) */
public class Product
{
 
	private int productId;
	private String proName;
	private double price;
 
	public void setProductId(int productId)
	{
	    this.productId = productId;
	}
	public int getProductId()
	{
	    return productId;
	}
 
	public void setProName(String proName)
	{
	    this.proName = proName;
	}
	public String getProName()
	{
	    return proName;
	}
 
	public void setPrice(double price)
	{
	    this.price = price;
	}
	public double getPrice()
	{
	    return price;
	}
}