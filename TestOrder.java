import  java.io.*;
import  java.util.*;

/**
 * Test driver for class <code>Order</code>.
 *
 * @author  author name
 * @version  1.0.0
 */
public class TestOrder  {

	/* Standard output stream */
	private static PrintWriter  stdOut =
		new  PrintWriter(System.out, true);

	/* Standard error stream */
	private static PrintWriter  stdErr =
		new  PrintWriter(System.err, true);

	/**
	 * Displays a message in the standard error stream if the value specified
	 * by argument <code>condition<code> is <code>false</code>.
	 *
	 * @param message  the error message.
	 * @param condition  the test condition.
	 */
	public static void assertTrue(String message, boolean condition) {

		if (!condition) {
			stdErr.print("** Test failure ");
			stdErr.println(message);
		}
	}

	/**
	 * Displays a message in the standard error stream.
	 *
	 * @param message  the error message.
	 */
	public static void fail(String message) {

		stdErr.print("** Test failure ");
		stdErr.println(message);
	}

	/**
	 * Test driver for class <code>Order</code>.
	 *
	 * @param args  not used.
	 */
	public static void  main(String[] args)  {

		Product product0 = new Product("P000",
			"product 0", 0.00);
		Product product1 = new Product("P001",
		 	"product 1", 1.00);
		Product product2 = new Product("P002",
			"product 2", 2.00);
		Product product3 = new Product("P003",
			"product 3", 3.00);
		OrderItem item0 = new OrderItem(product0, 1);
		OrderItem item1 = new OrderItem(product1, 2);
		OrderItem item2 = new OrderItem(product2, 3);
		OrderItem item3 = new OrderItem(product3, 4);
		
		// Product[] products = {product0, product1, product2, product3};
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(product0);
		products.add(product1);
		products.add(product2);
		products.add(product3);

		//OrderItem[] items = {item0, item1, item2, item3};
		// OrderItem[] removedItems = {item0, item3};
		// OrderItem[] notRemovedItems = {item1, item2};
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		items.add(item0);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		ArrayList<OrderItem> removedItems = new ArrayList<OrderItem>();
		removedItems.add(item0);
		removedItems.add(item3);
		ArrayList<OrderItem> notRemovedItems = new ArrayList<OrderItem>();
		notRemovedItems.add(item1);
		notRemovedItems.add(item2);


		Product product4 = new Product("P004",
			"product 4", 4.00);
		Product product5 = new Product("P005",
			"product 5", 5.00);
		// Product[] badProducts = {product4, product5};	
		ArrayList<Product> badProducts = new ArrayList<Product>();
		badProducts.add(product4);
		badProducts.add(product5);
			
		Order order = new Order();
	
		// Testing get and getNumberOfItems
		assertTrue("1: testing method getNumberOfItems",
			order.getNumberOfItems() == 0);
		
		for (int i = 0; i < items.size(); i++) {
			order.addItem(items.get(i));
		
		}

		assertTrue("2: testing method getNumberOfItems",
			order.getNumberOfItems() == items.size());
		
		// testing getItem
		for (int i = 0; i <  items.size(); i++) {
			assertTrue("3: testing method getItem",
				order.getItem(products.get(i)) == items.get(i));
		}
			
		for (int i = 0; i <  badProducts.size(); i++) {
			assertTrue("4: testing method getItem",
				order.getItem(badProducts.get(i)) == null);
		}
		
		// testing getTotalCost
		double result = 0.0;	
		for (int i = 0; i <  items.size(); i++) {
			result += items.get(i).getValue();
		}
		assertTrue("5: testing method getTotalCost",
			order.getTotalCost() == result);
			
		
		// testing getItemsIterator
		// Iterator<OrderItem> iterator = order.getItemsIterator();
		
		// for (int i = 0; i <  items.size(); i++) {
			int a = 0;
			for(OrderItem o : items) {
			if (!(o == null)){
				assertTrue("6: testing method getItemsIterator",
					o == items.get(a));
					a++;
			} else {
				fail("7: testing method getItemsIterator");
			}
		}
		
		// testing removeItems
		for (int i = 0; i < removedItems.size(); i++) {
			order.removeItem(removedItems.get(i));
		}			
	
		assertTrue("8: testing method removeItems",
			order.getNumberOfItems() == notRemovedItems.size());
	
		for (int i = 0; i <  notRemovedItems.size(); i++) {
			assertTrue("9: testing method removeItems",
				order.getItem(notRemovedItems.get(i).getProduct()) ==
					notRemovedItems.get(i));
		}
	
		for (int i = 0; i <  removedItems.size(); i++) {
			assertTrue("10: testing method removeItems",
				order.getItem(removedItems.get(i).getProduct()) == null);
		}
		
		stdOut.println("done");
	}
}
