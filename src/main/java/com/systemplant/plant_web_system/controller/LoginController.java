package com.systemplant.plant_web_system.controller;

import com.systemplant.plant_web_system.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String getPage(){
        return  "login";
    }
}
