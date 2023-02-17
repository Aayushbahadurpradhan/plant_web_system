package com.systemplant.plant_web_system.service;
import com.systemplant.plant_web_system.Entity.Category;
import com.systemplant.plant_web_system.pojo.CategoryPojo;

import java.util.List;

public interface CategoryService {

    List<Category> fetchAll();

    String saveUser (CategoryPojo categoryPojo);

    Category fetchById(Integer id);

    void deleteById(Integer id);
}
