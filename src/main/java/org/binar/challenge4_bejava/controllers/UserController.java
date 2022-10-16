package org.binar.challenge4_bejava.controllers;

import org.binar.challenge4_bejava.models.entities.UserEntity;
import org.binar.challenge4_bejava.dto.ResponseData;
import org.binar.challenge4_bejava.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseData<UserEntity>> create(@Valid @RequestBody UserEntity user , Errors errors){
        ResponseData<UserEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(userService.addUser(user));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/{id}")
    public UserEntity findUser(@PathVariable("id") Long ID){
        return userService.findUser(ID);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseData<UserEntity>> update(@Valid @RequestBody UserEntity user , Errors errors){
        ResponseData<UserEntity> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(userService.addUser(user));
        return ResponseEntity.ok(responseData);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long ID){
        userService.deleteUser(ID);
    }

    @GetMapping("/all")
    public Iterable<UserEntity> findAllFilms(){
        return userService.findAll();
    }

}
