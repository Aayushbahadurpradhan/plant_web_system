package com.systemplant.plant_web_system.controller;


import com.systemplant.plant_web_system.service.CategoryService;
import com.systemplant.plant_web_system.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PlantService plantService;
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("category",categoryService.fetchAll());
        model.addAttribute("plant", plantService.getAllPlant());
        return "dashboard";
    }
    @GetMapping("/shop")
    public  String shop(Model model){
        model.addAttribute("category",categoryService.fetchAll());
        model.addAttribute("plant", plantService.getAllPlant());
        return"/user/shop";
    }
}
