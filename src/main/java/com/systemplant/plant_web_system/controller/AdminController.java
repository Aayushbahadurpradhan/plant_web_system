package com.systemplant.plant_web_system.controller;



import com.systemplant.plant_web_system.Entity.Category;
import com.systemplant.plant_web_system.pojo.CategoryPojo;
import com.systemplant.plant_web_system.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final CategoryService categoryService;

    @GetMapping
    public String adminHome(){
        return "admin/adminHome";
    }
    @GetMapping("/categories")
    public String getCategoriesPage(Model model){
        List<Category> category=categoryService.fetchAll();
        model.addAttribute("categoryList",category);
        return "/admin/categories";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("category",new CategoryPojo());
        return "/admin/categoriesAdd";
    }

    @GetMapping("/admin/list")
    public String getCategoriesList(Model model){
        List<Category> category=categoryService.fetchAll();
        model.addAttribute("categoryList",category);
        return "/admin/categories";
    }
    @PostMapping("/add")
    public String saveUser (@Valid CategoryPojo categoryPojo){
        categoryService.saveUser(categoryPojo);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String getEditAction(@PathVariable("id") Integer id, Model model){
        Category category= categoryService.fetchById(id);
        model.addAttribute("category",new CategoryPojo(category));
        return "/admin/categoriesAdd";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteAction(@PathVariable("id") Integer id,Model model){
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }

}