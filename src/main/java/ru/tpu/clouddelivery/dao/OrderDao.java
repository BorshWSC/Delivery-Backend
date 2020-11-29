package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer> {
}
