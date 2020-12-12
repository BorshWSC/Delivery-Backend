package ru.tpu.clouddelivery.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.dao.OrderDao;
import ru.tpu.clouddelivery.exceptions.NotFoundException;
import ru.tpu.clouddelivery.model.Order;
import ru.tpu.clouddelivery.model.OrderedDish;
import ru.tpu.clouddelivery.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {

    private OrderDao orderDao;
    private UserService userService;
    private DishService dishService;
    private OrderedDishService orderedDishService;

    @Autowired
    public OrderService(
            OrderDao orderDao,
            UserService userService,
            DishService dishService,
            OrderedDishService orderedDishService
    ) {
        this.orderDao = orderDao;
        this.userService = userService;
        this.dishService = dishService;
        this.orderedDishService = orderedDishService;
    }

    public Iterable<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrderById(String id) {
        return orderDao.findById(Integer.parseInt(id)).orElseThrow(NotFoundException::new);
    }

    public Order createOrder(Map<Integer, Integer> dishes, String userId) {
        User user = userService.getUserById(userId);
        Order order = new Order();
        order.setId(0);
        order.setUser(user);
        order.setOrderDate(new Date());
        AtomicInteger total = new AtomicInteger();
        dishes.forEach((key, value) -> {
            total.addAndGet(dishService.getDishById(key.toString()).getCost() * value);
        });
        order.setTotal(total.get());
        order = orderDao.save(order);
        Order finalOrder = order;
        dishes.forEach((key, value) -> {
            OrderedDish orderedDish = new OrderedDish();
            orderedDish.setId(0);
            orderedDish.setOrder(finalOrder);
            orderedDish.setCount(value);
            orderedDish.setDish(dishService.getDishById(key.toString()));
            orderedDishService.save(orderedDish);
        });
        return getOrderById(finalOrder.getId().toString());
    }

    public Order updateOrder(Order orderFromDb, Order newOrder) {
        BeanUtils.copyProperties(newOrder, orderFromDb, "id");
        return orderDao.save(orderFromDb);
    }

    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

}
