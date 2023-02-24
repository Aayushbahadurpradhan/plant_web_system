package com.systemplant.plant_web_system.service.impl;

import com.systemplant.plant_web_system.Entity.Category;
import com.systemplant.plant_web_system.Entity.Plant;
import com.systemplant.plant_web_system.pojo.PlantPojo;
import com.systemplant.plant_web_system.repo.plant_management.CategoryRepo;
import com.systemplant.plant_web_system.repo.plant_management.PlantRepo;
import com.systemplant.plant_web_system.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantImpl implements PlantService {
    @Autowired
    private final PlantRepo plantRepo;
    private final CategoryRepo categoryRepo;
//    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/rescources/static/images/";


    @Override
    public List<Plant> fetchAll() {
        return plantRepo.findAll();
    }

//    @Override
//    public String savePlant(PlantPojo plantPojo) throws IOException {
//        Plant plant = new Plant();
//        plant.setId(plantPojo.getId());
//        plant.setNamep(plantPojo.getNamep());
//        plant.setDescription(plantPojo.getDescription());
//        if (plantPojo.getImage()!=null){
//            StringBuilder fileNames = new StringBuilder();
//            System.out.println(UPLOAD_DIRECTORY);
//            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, plantPojo.getImage().getOriginalFilename());
//            fileNames.append(plantPojo.getImage().getOriginalFilename());
//            Files.write(fileNameAndPath, plantPojo.getImage().getBytes());
//            plant.setImage(plantPojo.getImage().getOriginalFilename());
//        }
//        plantRepo.save(plant);
//        return "Created";
//    }
    @Override
    public String savePlant(PlantPojo plantPojo) throws IOException {
        Plant plant = new Plant();
        plant.setId(plantPojo.getId());
        plant.setNamep(plantPojo.getNamep());
        plant.setDescription(plantPojo.getDescription());
        Category category= categoryRepo.findById(plantPojo.getCategory()).orElseThrow(null);
        plant.setCategory(category);
        plant.setImage(plantPojo.getImage());
        plantRepo.save(plant);
        return "Created";
    }

    @Override
    public Plant fetchById(Integer id) {
        return plantRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        plantRepo.deleteById(id);
    }

    @Override
    public List<Plant> getAllPlant() {
        return  plantRepo.findAll();
    }


}
