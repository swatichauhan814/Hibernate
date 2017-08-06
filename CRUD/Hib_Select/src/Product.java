/*
Files required to execute this program..
Product.java (My POJO class)
Product.hbm.xml  (Xml mapping file )
hibernate.cfg.xml  (Xml configuration file)
ClientProgram.java(java file to write our hibernate logic)
*/
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