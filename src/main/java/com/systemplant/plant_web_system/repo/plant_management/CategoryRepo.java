package com.systemplant.plant_web_system.repo.plant_management;

import com.systemplant.plant_web_system.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo  extends JpaRepository<Category,Integer> {


}
