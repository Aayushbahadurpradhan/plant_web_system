package com.systemplant.plant_web_system.pojo;

import com.systemplant.plant_web_system.Entity.Plant;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantPojo {
    private Integer id;

    @NotNull
    private String namep;

    @NotNull
    private String description;

    private MultipartFile image;


    public PlantPojo(Plant plant){
        this.id=plant.getId();
        this.namep=plant.getNamep();
        this.description=getDescription();

    }
}
