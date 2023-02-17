package com.systemplant.plant_web_system.controller;

import com.systemplant.plant_web_system.Entity.User;
import com.systemplant.plant_web_system.pojo.UserPojo;
import com.systemplant.plant_web_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping
    public String getPage() {
        return "Hello_page";
    }


    @GetMapping("/index")
    public String getIndexPage(){
        return "user/index";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("user",new UserPojo());
        return "user/create";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new UserPojo());
        return "user/register";
    }

    @GetMapping("/list")
    public String getUserList(Model model){
        List<User> users=userService.fetchAll();
        model.addAttribute("userList",users);
        return "user/index";
    }
    @PostMapping("/save")
    public String saveUser (@Valid UserPojo userPojo){
    userService.saveUser(userPojo);
    return "redirect:/user/register";
    }

    @GetMapping("/edit/{id}")
    public String getEditAction(@PathVariable("id") Integer id,Model model){
        User user= userService.fetchById(id);
        model.addAttribute("user",new UserPojo(user));
        return "/user/create";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteAction(@PathVariable("id") Integer id,Model model){
        userService.deleteById(id);
        return "redirect:/user/list";
    }

}
