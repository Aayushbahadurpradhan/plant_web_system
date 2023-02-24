package com.systemplant.plant_web_system.service.impl;

import com.systemplant.plant_web_system.Entity.Category;
import com.systemplant.plant_web_system.pojo.CategoryPojo;
import com.systemplant.plant_web_system.repo.plant_management.CategoryRepo;
import com.systemplant.plant_web_system.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("admin.dir") + "/category";


    @Override
    public List<Category> fetchAll() {
        return categoryRepo.findAll();
    }

    @Override
    public String saveUser(CategoryPojo categoryPojo) {
        Category category = new Category();
        category.setId(categoryPojo.getId());
        category.setName(categoryPojo.getName());
        category.setImage(categoryPojo.getImage());
        categoryRepo.save(category);
        return "Created";
    }

    @Override
    public Category fetchById(Integer id) {
        return categoryRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepo.deleteById(id);
    }

}
