import  java.io.*;
import  java.util.*;

/**
 * Test driver for class <code>Sales</code>.
 *
 * @author  author name
 * @version  1.0.0
 */
public class TestSales  {

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
	 */
	public static void assertTrue(String message, boolean condition) {

		if (! condition) {
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
	 * Test driver for class <code>Sales</code>.
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

		ArrayList<Product> products = new ArrayList<Product>();
		products.add(product0);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		OrderItem item0 = new OrderItem(product0, 1);
		OrderItem item1 = new OrderItem(product1, 2);
		OrderItem item2 = new OrderItem(product2, 3);
		OrderItem item3 = new OrderItem(product3, 4);
		OrderItem item4 = new OrderItem(product0, 5);
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		items.add(item0);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Order order0 = new Order();
		order0.addItem(item0);
		order0.addItem(item1);
		Order order1 = new Order();
		order1.addItem(item2);
		order1.addItem(item3);
		Order order2 = new Order();
		order2.addItem(item4);
		
		// Order[] orders = {order0, order1, order2};
		ArrayList<Order> orders = new ArrayList<Order>();
		
		orders.add(order0);
		orders.add(order1);
		orders.add(order2);

		ArrayList<Order> removedOrders = new ArrayList<Order>();
		ArrayList<Order> notRemovedOrders = new ArrayList<Order>();
		removedOrders.add(order0);
		notRemovedOrders.add(order1);
		notRemovedOrders.add(order2);
		
		
		

		Sales sales = new Sales();
		
		assertTrue("1: testing method getNumberOfOrders",
			sales.getNumberOfOrders() == 0);
		
		for (int i = 0; i < orders.size(); i++) {
			sales.addOrder(orders.get(i));
			
		}
		Sales removed = new Sales();
		
		for (int i = 0; i < orders.size(); i++) {
			removed.addOrder(orders.get(i));
			
		}
		Sales notremoved = new Sales();
		for (int i = 1; i < 3; i++) {
			notremoved.addOrder(orders.get(i));
			
		}
		
		assertTrue("2: testing method getNumberOfOrders",
			sales.getNumberOfOrders() == orders.size());

		// testing getOrdersIterator
		// Iterator<Order> iterator = sales.getOrdersIterator();
		
		// for (int i = 0; i <  orders.length; i++) {
			int a=0;
			for(Order o : orders){
			if (!(o==null)) {
				assertTrue("3: testing method getOrdersIterator",
					o == orders.get(a));
					a++;
			} else {
				fail("4: testing method getOrdersIterator");
			}
		}

		// testing removeOrders
		for (int i = 0; i < removedOrders.size(); i++) {
			sales.removeOrder(removedOrders.get(i));
		}			
		
		assertTrue("8: testing method removeOrders",
		sales.getNumberOfOrders() == notRemovedOrders.size());

		
			
		for (int b = 0; b < items.size(); b++) {
			assertTrue("9: testing method removeItems",
			sales.getOrder(items.get(b)) ==
					notremoved.getOrder(items.get(b)));
			}
		
	
		
		for (int i = 0; i <  removedOrders.size(); i++) {
			Order o =removedOrders.get(i);
		for(int b = 0; b < items.size(); b++) {
			if((sales.getOrder(items.get(b)))==o && (sales.getOrder(items.get(b))==null)){
			assertTrue("10: testing method removeItems",true);
		}
		}
		}	
		stdOut.println("done");
	}
}
