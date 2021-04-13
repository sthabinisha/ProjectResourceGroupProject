package com.itlize.res.service;

import com.itlize.res.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService{

    public List<User> getAllUsers ();
    String deleteUserByID(Integer pID);
//    public User getUserName(Integer userId);
//    public User saveUser(User user);
    public Optional<User>  getUserByID(Integer userId);

    public void updateTitleofUser(Integer id, User user);
//
//    User loadUserByUserName(String username) throws UserNotFoundException;
//
//    User loadUserById(Integer userId);
}
