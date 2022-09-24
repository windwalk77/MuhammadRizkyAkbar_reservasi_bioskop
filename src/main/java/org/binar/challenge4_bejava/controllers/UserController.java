package org.binar.challenge4_bejava.controllers;

import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.services.UserService;
import org.binar.challenge4_bejava.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create")
    public UserEntity create(@RequestBody UserEntity user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserEntity findUser(@PathVariable("id") Long ID){
        return userService.findUser(ID);
    }

    @PutMapping("/update")
    public UserEntity updateUser(@RequestBody UserEntity user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long ID){
        userService.deleteUser(ID);
    }
}
