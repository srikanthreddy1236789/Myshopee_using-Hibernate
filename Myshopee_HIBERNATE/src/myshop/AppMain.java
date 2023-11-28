package myshop;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppMain {
	private SessionFactory sesfact;
	private Session ses;
	private Transaction tx;
	private Scanner sc;
	public AppMain()
	{
		sesfact=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		sc=new Scanner(System.in);
	}
	public void insert()
	{
		ses=sesfact.openSession();
		ses.beginTransaction();
		Customer c1=new Customer();
		c1.setCustomer_code("C001");
		c1.setCustomer_name("Srikanth");
		c1.setPhone_number("7981299156");
		c1.setAddress("Vijayawada");
		
		Item i1=new Item();
		i1.setItem_code("I001");
		i1.setItem_name("Mouse");
		i1.setItem_price(300);
		i1.setQoh(4);
		i1.setCusobj(c1);
		
		Item i2=new Item();
		i2.setItem_code("I002");
		i2.setItem_name("Pen");
		i2.setItem_price(5);
		i2.setQoh(40);
		i2.setCusobj(c1);
		
		Set<Item> itemset=new HashSet<>();
		itemset.add(i1);
		itemset.add(i2);
		
		c1.setItemlst(itemset);
		ses.save(c1);
		
		ses.getTransaction().commit();
		ses.close();
		
		
		
	}
	public void retrive()
	{
		ses=sesfact.openSession();
		Query q=ses.createQuery("select c from Customer c where customer_code=:code");
		q.setParameter("code", "C001");
		List<Customer> cus=q.list();
		for(Customer c:cus)
		{
			Set<Item> itm=c.getItemlst();
			for(Item i:itm)
			{
				System.out.println("Item name is "+i.getItem_name());
				System.out.println("Item Price is "+i.getItem_price());
			}
		}
		
	}
	public void searchByCustId()
	{
		System.out.println("Enter the Customer code");
		String cuscode=sc.next();
		ses=sesfact.openSession();
		Query q=ses.createQuery("select c from Customer c where customer_code=:code");
		q.setParameter("code", cuscode);
		List<Customer> cus=q.list();
		for(Customer c:cus)
		{
			System.out.println("Customer Name is "+c.getCustomer_name());
			System.out.println("Customer Ph Number is "+c.getPhone_number());
			System.out.println("Customer Address is "+c.getAddress());
		}
		
	}
	public void searchByItemid()
	{
		System.out.println("Enter the Item Id");
		String itemid=sc.next();
		ses=sesfact.openSession();
		Query q1=ses.createQuery("select i from Item i where item_code=:id");
		q1.setParameter("id", itemid);
		List<Item> itm=q1.list();
		if(itm==null)
		{
			System.out.println("No Item found");
		
		}
		else
		{
			for(Item i:itm)
			{
				System.out.println("Item name is "+i.getItem_name());
				System.out.println("Item price is "+i.getItem_price());
			}
			
		}
	}
	
	public static void main(String[] args) {
		AppMain app=new AppMain();
		//app.insert();
		//app.searchByCustId();
		app.searchByItemid();
	}

}
