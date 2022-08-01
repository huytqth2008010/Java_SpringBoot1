package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Category;
import com.example.java_springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, path = "/categories")
    public Page<Category> getList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "1") int limit) {
        return categoryService.findAll(page, limit);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories/get-all")
    public List<Category> getList() {
        return categoryService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/categories")
    public Category save(@RequestBody Category category) {
        categoryService.save(category);
        return category;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories/{id}")
    public Category getDetail(@PathVariable Integer id) {
        return categoryService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/categories/{id}")
    public boolean delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/categories/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category categoryUpdate) {
        Category existing = categoryService.findById(id).get();
        existing.setName(categoryUpdate.getName());
        categoryService.save(existing);
        return categoryUpdate;
    }

}

