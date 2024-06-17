package com.bikkadit.demo.service.Impl;

import com.bikkadit.demo.model.User;
import com.bikkadit.demo.repository.UserRepository;
import com.bikkadit.demo.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserServiceI {


  //  Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    //create User
    @Override
    public User createUser(User user) {

        log.info("Intiating the dao call for save user data");
        User saveUser = userRepository.save(user);
        log.info("Completed the dao call for save user data");
        return saveUser;
    }
        //update User
    @Override
    public User updateUser(User user, Long userId) {
        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());
        User updateUser = userRepository.save(user1);
        return updateUser;
    }
        //GET single data
    @Override
    public User getsingleUser(Long userId) {
        log.info("Intiating the dao call for  user get single user data userId {}:",userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resources Not Found on Server"+ userId));

        log.info("Intiating the dao call for get single  user data as userId {}:",userId);
        return user;
        /* OR */
//        Optional<User> user = userRepository.findById(userId);
//
//        if(user.isPresent()){
//            return user.get();
//        }else {
//            throw new Exception("Resources Not Found on Server" + userId);
//
//        }

    }
    //GET all data
    @Override
    public List<User> getAllUser() {
        List<User>  alluser = userRepository.findAll();
        return alluser;
    }
        //Delete User
    @Override
    public void deleteUser(Long userId) {

        log.info("Intiating the dao call for  user get single user data userId {}:",userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(("Resource Not Found on server" + userId)));
        log.info(" Complete the dao call for Deleting  user data as userId {}:",userId);
        userRepository.delete(user);
    }
}
