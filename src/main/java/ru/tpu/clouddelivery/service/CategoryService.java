package ru.tpu.clouddelivery.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.model.Category;
import ru.tpu.clouddelivery.exceptions.NotFoundException;
import ru.tpu.clouddelivery.dao.CategoryDao;

@Service
public class CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Iterable<Category> getAllCategories() {
        return categoryDao.findAll();
    }

    public Category getCategoryById(String id) {
        return categoryDao.findById(Integer.parseInt(id)).orElseThrow(NotFoundException::new);
    }

    public Category createCategory(Category category) {
        return categoryDao.save(category);
    }

    public Category updateCategory(Category categoryFromDb, Category newCategory) {
        BeanUtils.copyProperties(newCategory, categoryFromDb, "id");
        return categoryDao.save(categoryFromDb);
    }

    public void deleteCategory(Category category) {
        categoryDao.delete(category);
    }
}
