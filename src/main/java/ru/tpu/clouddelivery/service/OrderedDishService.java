package ru.tpu.clouddelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.dao.OrderedDishDao;
import ru.tpu.clouddelivery.model.OrderedDish;

@Service
public class OrderedDishService {

    private OrderedDishDao orderedDishDao;

    @Autowired
    public OrderedDishService(OrderedDishDao orderedDishDao) {
        this.orderedDishDao = orderedDishDao;
    }

    public OrderedDish save (OrderedDish orderedDish) {
        return orderedDishDao.save(orderedDish);
    }
}
