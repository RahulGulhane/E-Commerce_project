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
    public ResponseEntity<User> create(User user){
        User saveuser = userServiceI.createUser(user);
        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);
    }
//    @PostMapping("/Users")
//    ResponseEntity<User> createUser(User user){
//        User saveuser = userServiceI.createUser(user);
//        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);
//    }


    //GetAllUsers
    @GetMapping("/Users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser = userServiceI.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
//    @GetMapping("/users")
//    ResponseEntity<List<User>> getAllUser(){
//        List<User> allUsers = userServiceI.getAllUser();
//       return new ResponseEntity<>(allUsers, HttpStatus.OK);
//    }
    //GET single user
    @GetMapping("/users/{UsersId}")
    public ResponseEntity<User> getsinglUser(@PathVariable Long userId){
        User user1 = userServiceI.getsingleUser(userId);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

//    @GetMapping("/users/{UserId}")
//    public ResponseEntity<User> getSingleUser(@PathVariable long userId){
//        User user = userServiceI.getsingleUser(userId);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
    //updateUser
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
        User updateUser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
//    @PutMapping("/users/{UserId}")
//    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
//        User updateuser = userServiceI.updateUser(user, userId);
//        return new ResponseEntity<>(updateuser,HttpStatus.OK);
//    }
    //Delete
    @DeleteMapping("/users/{UserId}")
    public ResponseEntity Delete(Long userId){
        userServiceI.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("Resource Delete Successful");
    }//  OR
//    public ResponseEntity deleteUser(@PathVariable Long userId){
//        userServiceI.deleteUser(userId);
//        return new ResponseEntity<>("Resource Delete Successful ",HttpStatus.OK);
//    }




}
