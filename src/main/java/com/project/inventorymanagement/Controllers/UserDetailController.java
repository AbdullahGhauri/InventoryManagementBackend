package com.project.inventorymanagement.Controllers;

import com.project.inventorymanagement.DTOs.User;
import com.project.inventorymanagement.Repositories.UserRepository;
import com.project.inventorymanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDetail")
public class UserDetailController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser/{userId}")
    public User userDetailById(@PathVariable long userId){  return userService.getUserById(userId); }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){  return userService.getAllUser(); }

    @PutMapping("/updateUser/{userId}")
    public User updateUserById(@PathVariable long userId,User user){ return userService.updateUser(userId,user); }
}
