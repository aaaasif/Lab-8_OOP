import java.util.Vector;
import java.util.Iterator;
public class Catalog {
    private Vector<Product> products = new Vector<Product>();

    public Catalog(){
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public Iterator<Product> getProductsIterator(){
           return this.products.iterator();
    }

    public Product getProduct(String code) {
        for(Product p : this.products){
            if(p.getCode().equals(code)){
                return p;
            }
        }
        return null;
     }
  

    public int getNumberOfProducts(){
        return this.products.size();
    }
}
