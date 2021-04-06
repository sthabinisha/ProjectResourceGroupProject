package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.User;
import com.itlize.res.exception.UserNotFoundException;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUserByID(Integer uID) {
         userRepository.deleteById(uID);
        return "User removed !! " + uID;

    }

    @Override
    public User getUserName(Integer userId) {
        return userRepository.findById(userId) .orElseThrow(()-> new UserNotFoundException("User by userId: "+ userId+ " was not found"));

    }



    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserID()).orElse(null);
        existingUser.setUsername(user.getUsername());
        existingUser.setRole(user.getRole());

        existingUser.setUsername(user.getUsername());



        return userRepository.save(existingUser);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User>  getUserByID(Integer userId) {
        return userRepository.findById(userId);
    }
}
