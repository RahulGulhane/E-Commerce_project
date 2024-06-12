package com.bikkadit.demo.service.Impl;

import com.bikkadit.demo.model.User;
import com.bikkadit.demo.repository.UserRepository;
import com.bikkadit.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        User user1 = userRepository.findById(userId).get();
        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());
        User updateUser = userRepository.save(user1);
        return updateUser;
    }

    @Override
    public User getsingleUser(Long UserId) {
        userRepository.findById(UserId);
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void deleteUser(Long UserId) {

    }
}
