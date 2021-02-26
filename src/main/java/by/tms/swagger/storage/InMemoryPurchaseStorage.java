package by.tms.swagger.storage;

import by.tms.swagger.models.Order;
import by.tms.swagger.models.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPurchaseStorage {
    private static List<Order> orders = new ArrayList<>();

    public boolean add(Order order) {
        if (orders.contains(order)) {
            return false;
        }
        orders.add(order);
        return true;
    }

    public Order getById(int id){
        for (Order order : orders) {
            if (order.getId()==id) {
                return order;
            }
        }
        return null;
    }

    public boolean deleteById(int id){
        for (Order order : orders) {
            if (order.getId()==id) {
                orders.remove(order);
                return true;
            }
        }
        return false;
    }

    public List<Order> getOrders(){
        return new ArrayList<>(orders);
    }


}
