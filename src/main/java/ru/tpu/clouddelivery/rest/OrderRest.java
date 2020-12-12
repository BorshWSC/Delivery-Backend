package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.Dish;
import ru.tpu.clouddelivery.model.Order;
import ru.tpu.clouddelivery.service.OrderService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/order")
public class OrderRest {

    private OrderService orderService;

    @Autowired
    public OrderRest(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public Iterable<Order> list() {
        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public Order getOne(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/create/{id}")
    public Order create(@RequestBody Map<Integer, Integer> dishes, @PathVariable String id){
        return orderService.createOrder(dishes, id);
    }

    @PutMapping("{id}")
    public Order update(@PathVariable("id") Order orderFromDb, @RequestBody Order newOrder) {
        return orderService.updateOrder(orderFromDb, newOrder);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Order orderFromDB) {
        orderService.deleteOrder(orderFromDB);
    }
}
