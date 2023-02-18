package com.systemplant.plant_web_system.repo.plant_management;

import com.systemplant.plant_web_system.Entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepo extends JpaRepository<Plant, Integer> {
//    Plant findById(long id);
//    Plant findByName(String name);
//    List<Plant> findAllByOrderByIdAsc();
//    List<Plant> findAllByCategoryId(long categoryId);

}
