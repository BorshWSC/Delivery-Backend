package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.Dish;
import ru.tpu.clouddelivery.service.DishService;

@RestController
@RequestMapping(value = "dishFromDb")
public class DishRest {

    private DishService dishService;

    @Autowired
    public DishRest(DishService dishService) {
        this.dishService = dishService;
    }
    @GetMapping()
    public Iterable<Dish> list() {
        return dishService.getAllDishes();
    }

    @GetMapping("{id}")
    public Dish getOne(@PathVariable String id) {
        return dishService.getDishById(id);
    }

    @PostMapping("/create")
    public Dish create(@RequestBody Dish dis){
        return dishService.createDish(dis);
    }

    @PutMapping("{id}")
    public Dish update(@PathVariable("id") Dish dishFromDb, @RequestBody Dish newDish) {
        return dishService.updateDish(dishFromDb, newDish);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Dish userFromDB) {
        dishService.deleteDish(userFromDB);
    }
}
