package com.bikkadit.demo.service;

import com.bikkadit.demo.model.User;

import java.util.List;

public interface UserServiceI {
    //create
    User createUser(User user);

    //update
    User updateUser(User user, Long userId);

    //GET single data

    User getsingleUser(Long UserId);

    //GET all data
    List<User> getAllUser();


    //Delete
    void deleteUser(Long UserId);
}
