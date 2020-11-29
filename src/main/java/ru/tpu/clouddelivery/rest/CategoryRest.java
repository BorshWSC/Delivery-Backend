package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.Category;
import ru.tpu.clouddelivery.service.CategoryService;

@RestController
@RequestMapping(value = "category")
public class CategoryRest {

    private CategoryService categoryService;

    @Autowired
    public CategoryRest(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public Iterable<Category> list() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public Category getOne(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id") Category categoryFromDb, @RequestBody Category newCategory) {
        return categoryService.updateCategory(categoryFromDb, newCategory);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Category category) {
        categoryService.deleteCategory(category);
    }
}
