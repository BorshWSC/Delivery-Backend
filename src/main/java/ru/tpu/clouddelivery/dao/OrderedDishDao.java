package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.OrderedDish;

public interface OrderedDishDao extends CrudRepository<OrderedDish, Integer> {
}
