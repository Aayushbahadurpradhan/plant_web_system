//package com.systemplant.plant_web_system.controller;//package com.systemplant.plant_web_system.controller;
////
////import com.systemplant.plant_web_system.pojo.CategoryPojo;
////import com.systemplant.plant_web_system.pojo.PlantPojo;
////import com.systemplant.plant_web_system.service.CategoryService;
////import com.systemplant.plant_web_system.service.PlantService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////
////public class HomeController {
////    @Autowired
////    CategoryService categoryService;
////    @Autowired
////    PlantService plantService;
////
////    @GetMapping("/home")
////    public  String home(Model model){
////        return"shop";
////    }
////    @GetMapping("/shop")
////    public  String shop(Model model){
////        model.addAttribute("category",categoryService.fetchAll());
////        model.addAttribute("plant", plantService.getAllPlant());
////        return"/user/shop";
////    }
////}
//
//
//import com.systemplant.plant_web_system.Entity.Plant;
//import com.systemplant.plant_web_system.service.CategoryService;
//import com.systemplant.plant_web_system.service.PlantService;
//import com.systemplant.plant_web_system.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class HomeController {
//    private final UserService userService;
//    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/coffee_shop";
//    //    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/Images";
//    @Autowired
//    PlantService plantService;
//    @Autowired
//    CategoryService categoryService;
//
//    @GetMapping("/shopNow")
//    public String shopNow(Model model){
//        model.addAttribute("products",plantService.getAllPlant());
//        return "UserProduct";
//    }
//    @PostMapping("/shopNow")
//    public String postProdAdd(@ModelAttribute("plant") Plant plant){
//        plantService.savePlant(plant);
//        return "redirect:/user/shopNow";
//    }
//    @GetMapping("/userHome/menu")
//    public String menu(Model model){
//        model.addAttribute("categories", categoryService.fetchAll());
//        model.addAttribute("products",plantService.getAllPlant());
//        return "menu";
//    }
//    @GetMapping("/userHome/contact")
//    public String contact(Model model){
//        return "contact";
//    }
//

//    @GetMapping("/user/userHome/menu/category/{id]")
//    public String menuByCategory(Model model, @PathVariable int id){
//        model.addAttribute("categories",categoryService.getAllCategory());
//        model.addAttribute("products",productService.getProductById(id));
//        return "menu";
////    }
//}
