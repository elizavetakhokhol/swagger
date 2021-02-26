package by.tms.swagger.service;
import by.tms.swagger.models.Order;
import by.tms.swagger.storage.InMemoryPurchaseStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    InMemoryPurchaseStorage inMemoryPurchaseStorage;

    public boolean save(Order order){
        return inMemoryPurchaseStorage.add(order);
    }

    public boolean deleteById(int id){
        return inMemoryPurchaseStorage.deleteById(id);
    }

    public Order getById(int id){
        return inMemoryPurchaseStorage.getById(id);
    }
}
