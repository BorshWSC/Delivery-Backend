package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.Category;

public interface CategoryDao extends CrudRepository<Category, Integer> {
}
