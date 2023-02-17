package com.systemplant.plant_web_system.pojo;

import com.systemplant.plant_web_system.Entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPojo {
    private Integer id;

    @NotNull
    private String name;

    public CategoryPojo(Category category){
        this.id=category.getId();
        this.name=category.getName();
    }
}
