package com.systemplant.plant_web_system.service;


import com.systemplant.plant_web_system.Entity.Category;
import com.systemplant.plant_web_system.Entity.Plant;
import com.systemplant.plant_web_system.pojo.CategoryPojo;
import com.systemplant.plant_web_system.pojo.PlantPojo;

import java.io.IOException;
import java.util.List;

public interface PlantService {
    List<Plant> fetchAll();

    String savePlant (PlantPojo plantPojo) throws IOException;

    Plant fetchById(Integer id);

    void deleteById(Integer id);
}
