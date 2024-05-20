import java.util.Vector;
import java.util.Iterator;
public class Sales {
    private Vector<Order> orders = new Vector<Order>();
  
    public Sales(){
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void removeOrder(Order order){
        this.orders.remove(order);
    }

    public Order getOrder(OrderItem orderItem) {
        for (Order o : this.orders) {
            if (o.getItem(orderItem.getProduct())==(orderItem)) {
                return o;
            }
        }
        return null;
    }
    
    
    public Iterator<Order> getOrdersIterator(){
        return this.orders.iterator();
    }

    public int getNumberOfOrders(){
        return this.orders.size();
    }
    
}
