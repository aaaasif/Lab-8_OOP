import java.util.Vector;
import java.util.Iterator;
public class Order {
    private Vector<OrderItem> items = new Vector<OrderItem>();
    
    public Order(){
    }

    public void addItem(OrderItem orderItem){
        this.items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        this.items.remove(orderItem);
    }

    public Iterator<OrderItem> getItemsIterator(){
        return this.items.iterator();
    }

    public OrderItem getItem(Product product){
        for(OrderItem o : this.items){
            if(o.getProduct().equals(product)){
                return o;
            }
        }
        return null;
    }

    public int getNumberOfItems(){
        return this.items.size();
    }

    public double getTotalCost(){
        double c = 0;
        for(OrderItem o : this.items){
            c += o.getValue();
        }
        return c;
    }
    
      
        @Override
        public String toString() {
          return  this.items + " " ;
        }
      }
      

