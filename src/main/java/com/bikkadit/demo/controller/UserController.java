package com.bikkadit.demo.controller;


import com.bikkadit.demo.model.User;
import com.bikkadit.demo.service.UserServiceI;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {


    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceI userServiceI;

    //create
    @PostMapping("/Users")
    public ResponseEntity<User> create(User user){
        logger.info("Entering the request for save user data");
        User saveuser = userServiceI.createUser(user);
        logger.info("compete the request for save user data");
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
        logger.info("Entering the request for  getAlluser data");
        List<User> allUser = userServiceI.getAllUser();
        logger.info("Completed the request for getalluser data with  userId");
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
        logger.info("Entering the request for getsingleuser data with userId {}:",userId);
        User user1 = userServiceI.getsingleUser(userId);
        logger.info("Completed the request for getsingluser data with  userId {}:",userId);
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
        logger.info("Entering the request for update for update the user data with userId {}:",userId);
        User updateUser = userServiceI.updateUser(user, userId);
        logger.info("Completed the request for updatedata with  userId {}:",userId);
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
        ogger.info("Entering the request for delete for delete the user data with userId {}:",userId);
        userServiceI.deleteUser(userId);
        logger.info("Completed the request for delete with  userId {}:",userId);
        return ResponseEntity.status(HttpStatus.OK).body("Resource Delete Successful");
    }//  OR
//    public ResponseEntity deleteUser(@PathVariable Long userId){
//        userServiceI.deleteUser(userId);
//        return new ResponseEntity<>("Resource Delete Successful ",HttpStatus.OK);
//    }




}
