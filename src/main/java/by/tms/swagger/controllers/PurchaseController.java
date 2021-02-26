package by.tms.swagger.controllers;

import by.tms.swagger.models.Order;
import by.tms.swagger.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/purchase")
@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/order")
    public ResponseEntity<Order> newOrder(@RequestBody Order order) {
        purchaseService.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Order> deleteById(@PathVariable("id") int id) {
        if (purchaseService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") int id) {
        Order byId = purchaseService.getById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }
}
