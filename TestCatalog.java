import  java.io.*;
import  java.util.*;

/**
 * Test driver for class <code>Catalog</code>.
 *
 * @author  author name
 * @version  1.0.0
 */
public class TestCatalog  {

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
	 * Test driver for class <code>Catalog</code>.
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
		//Product[] products = {product0, product1, product2, product3};
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(product0);
		products.add(product1);
		products.add(product2);
		products.add(product3);



		Product product4 = new Product("P004",
			"product 4", 4.00);
		Product product5 = new Product("P005",
			"product 5", 5.00);
		//Product[] badProducts = {product4, product5};	
		ArrayList<Product> badProducts = new ArrayList<Product>();
		badProducts.add(product4);
		badProducts.add(product5);

		ArrayList<Product> removedProducts = new ArrayList<Product>();
		ArrayList<Product> notRemovedProducts = new ArrayList<Product>();
		removedProducts.add(product0);
		removedProducts.add(product3);
		notRemovedProducts.add(product1);
		notRemovedProducts.add(product2);

		Catalog catalog = new Catalog();
	
		// testing addProduct and getNumberOfProducts
		assertTrue("1: testing method getNumberOfProducts",
			catalog.getNumberOfProducts() == 0);
		
		for (int i = 0; i < products.size(); i++) {
			catalog.addProduct(products.get(i));
		}
			
		assertTrue("2: testing method getNumberOfProducts",
			catalog.getNumberOfProducts() == products.size());
		
		// testing getProduct	
		for (int i = 0; i <  products.size(); i++) {
			assertTrue("3: testing method getProduct",
				catalog.getProduct(products.get(i).getCode()) == products.get(i));
		}
			
		for (int i = 0; i <  badProducts.size(); i++) {
			assertTrue("4: testing method getProduct",
				catalog.getProduct(badProducts.get(i).getCode()) == null);
		}
		
		// testing getProductsIterator
		//Iterator<Product> iterator = catalog.getProductsIterator();
		
		//for (int i = 0; i <  products.size(); i++) {
			int a =0;
			for(Product p : products){
				if(!(p==null)){
					assertTrue("5: testing method getProductsIterator",
			 		p == products.get(a));
					a++;
				}else {
					 	fail("6: testing method getProductsIterator");
			}
		}
			// if (iterator.hasNext()) {
			// 	assertTrue("5: testing method getProductsIterator",
			// 		iterator.next() == products.get(i));
			// } else {
			// 	fail("6: testing method getProductsIterator");
			// }
		// }
		//}

		// testing removeProducts
		for (int i = 0; i < removedProducts.size(); i++) {
			catalog.removeProduct(removedProducts.get(i));
		}			
	
		assertTrue("8: testing method removeProducts",
			catalog.getNumberOfProducts() == notRemovedProducts.size());
	
		for (int i = 0; i <  notRemovedProducts.size(); i++) {
			assertTrue("9: testing method removeProducts",
				catalog.getProduct(notRemovedProducts.get(i).getCode()) ==
					notRemovedProducts.get(i));
		}
	
		for (int i = 0; i <  removedProducts.size(); i++) {
			assertTrue("10: testing method removeProducts",
				catalog.getProduct(removedProducts.get(i).getCode()) == null);
		}




		stdOut.println("done");
	}
}
