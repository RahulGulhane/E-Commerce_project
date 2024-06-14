package com.bikkadit.demo.controller;


import com.bikkadit.demo.model.User;
import com.bikkadit.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    //create
    @PostMapping("/Users")
    ResponseEntity<User> createUser(User user){
        User saveuser = userServiceI.createUser(user);
        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);
    }


    //GetAllUsers
    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers = userServiceI.getAllUser();
       return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    //GET single user
    @GetMapping("/users/{UserId}")
    public ResponseEntity<User> getSingleUser(@PathVariable long userId){
        User user = userServiceI.getsingleUser(userId);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    //updateUser
    @PutMapping("/users/{UserId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
        User updateuser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(updateuser,HttpStatus.OK);
    }
    //Delete
    public ResponseEntity deleteUser(@PathVariable Long userId){
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>("Resource Delete Successful ",HttpStatus.OK);
    }


}
