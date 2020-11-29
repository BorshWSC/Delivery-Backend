package ru.tpu.clouddelivery.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.dao.OrderDao;
import ru.tpu.clouddelivery.exceptions.NotFoundException;
import ru.tpu.clouddelivery.model.Order;

@Service
public class OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Iterable<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrderById(String id) {
        return orderDao.findById(Integer.parseInt(id)).orElseThrow(NotFoundException::new);
    }

    public Order createOrder(Order order) {
        return orderDao.save(order);
    }

    public Order updateOrder(Order orderFromDb, Order newOrder) {
        BeanUtils.copyProperties(newOrder, orderFromDb, "id");
        return orderDao.save(orderFromDb);
    }

    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

}
