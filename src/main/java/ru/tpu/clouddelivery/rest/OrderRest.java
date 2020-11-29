package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.Order;
import ru.tpu.clouddelivery.service.OrderService;

@RestController
@RequestMapping("order")
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

    @PostMapping("/create")
    public Order create(@RequestBody Order order){
        return orderService.createOrder(order);
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
