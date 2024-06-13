package com.bikkadit.demo.controller;


import com.bikkadit.demo.model.User;
import com.bikkadit.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserServiceI userServiceI;

    //create
    ResponseEntity<User> createUser(){

        return null;
    }


    //update

    //GET single data

    //GET all data

    //Delete



}
