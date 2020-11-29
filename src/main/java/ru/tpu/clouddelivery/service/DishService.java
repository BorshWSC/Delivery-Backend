package ru.tpu.clouddelivery.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.dao.DishDao;
import ru.tpu.clouddelivery.exceptions.NotFoundException;
import ru.tpu.clouddelivery.model.Dish;

@Service
public class DishService {

    private DishDao dishDao;

    @Autowired
    public DishService(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public Iterable<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    public Dish getDishById(String id) {
        return dishDao.findById(Integer.parseInt(id)).orElseThrow(NotFoundException::new);
    }

    public Dish createDish(Dish dish) {
        return dishDao.save(dish);
    }

    public Dish updateDish(Dish dishFromDb, Dish newDish) {
        BeanUtils.copyProperties(newDish, dishFromDb, "id");
        return dishDao.save(dishFromDb);
    }

    public void deleteDish(Dish dish) {
        dishDao.delete(dish);
    }
}
