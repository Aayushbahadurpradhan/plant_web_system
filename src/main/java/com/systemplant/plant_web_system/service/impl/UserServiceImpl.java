package com.systemplant.plant_web_system.service.impl;

import com.systemplant.plant_web_system.Entity.User;
import com.systemplant.plant_web_system.config.PasswordEncoderUtil;
import com.systemplant.plant_web_system.pojo.UserPojo;
import com.systemplant.plant_web_system.repo.plant_management.UserRepo;
import com.systemplant.plant_web_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    //
    // UserServiceImpl(UserRepo userrepo){
    // this.userRepo = userRepo;
    // }
    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public String saveUser(UserPojo userPojo) {
        User user = new User();
        user.setId(userPojo.getId());
        user.setEmail(userPojo.getEmail());
        user.setUsername(userPojo.getUser_name());
        user.setFullname(userPojo.getFullname());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "Created";
    }

    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

}
