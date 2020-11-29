package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.Dish;

public interface DishDao extends CrudRepository<Dish, Integer> {
}
