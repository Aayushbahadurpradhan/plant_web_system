package com.systemplant.plant_web_system.controller;

import com.systemplant.plant_web_system.Entity.Category;
import com.systemplant.plant_web_system.Entity.Plant;
import com.systemplant.plant_web_system.pojo.CategoryPojo;
import com.systemplant.plant_web_system.pojo.PlantPojo;
import com.systemplant.plant_web_system.service.CategoryService;
import com.systemplant.plant_web_system.service.PlantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final PlantService plantService;
    private final CategoryService categoryService;

    @GetMapping
    public String plantHome(){
        return "admin/plants";
    }

    @GetMapping("/plants")
    public String getPlantsPage(Model model){
        model.addAttribute("plantList", plantService.getAllPlant());
        model.addAttribute("categoryList",categoryService.fetchAll());
//        List<Plant> plant=plantService.fetchAll();
//        model.addAttribute("plantList", plant.stream().map(plante ->
//                Plant.builder()
//                        .id(plante.getId())
//                        .namep(plante.getNamep())
//                        .description(plante.getDescription())
//                        .image(plante.getImage())
////                        .imageBase64(getImageBase64(plante.getImage()))
//                        .build()
//        ));
        return "/admin/plants";
    }

    @GetMapping("/create")
    public String CreatePlant(Model model){
        model.addAttribute("plant",new PlantPojo());
        model.addAttribute("categoryList",categoryService.fetchAll());
//        model.addAttribute("plantList", plantService.getAllProduct());
        return "/admin/plantAdd";
    }

//    @GetMapping("/list")
//    public String getPlantsList(Model model){
//        List<Plant> plant=plantService.fetchAll();
//        model.addAttribute("plantList", plant.stream().map(plant1 ->
//                Plant.builder()
//                        .id(plant1.getId())
//                        .namep(plant1.getNamep())
//                        .description(plant1.getDescription())
//                        .image(plant1.getImage())
////                        .imageBase64(getImageBase64(plant1.getImage()))
//                        .build()
//        ));
////        model.addAttribute("UPLOAD_DIRECTORY", "/" + UPLOAD_DIRECTORY);
//        return "/admin/plants";
//    }
    @PostMapping("/plants")
    public String savePlant (@Valid PlantPojo plantPojo) throws IOException {
        plantService.savePlant(plantPojo);
        return "redirect:/product/plants";
    }

    @GetMapping("/edit/{id}")
    public String getEditAction(@PathVariable("id") Integer id, Model model){
        Plant plant= plantService.fetchById(id);
        model.addAttribute("plant",new PlantPojo(plant));
        return "/admin/plantAdd";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteAction(@PathVariable("id") Integer id,Model model){
        plantService.deleteById(id);
        return "redirect:/product/plants";
    }

//    public String getImageBase64(String fileName) {
////        String filePath = System.getProperty("user.dir") + "/src/main/rescources/static/images/";
//        File file = new File("https://media.istockphoto.com/id/637696304/photo/patan.jpg?s=612x612&w=0&k=20&c=-53aSTGBGoOOqX5aoC3Hs1jhZ527v3Id_xOawHHVPpg=");
//        byte[] bytes = new byte[0];
//        try {
//            bytes = Files.readAllBytes(file.toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        String base64 = Base64.getEncoder().encodeToString(bytes);
//        return base64;
//    }

}
