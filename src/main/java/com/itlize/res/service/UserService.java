package com.itlize.res.service;

import com.itlize.res.entity.Project;
import com.itlize.res.entity.Resource;
import com.itlize.res.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService{

    public List<User> getAllUsers ();
    String deleteUserByID(Integer pID);

    public User getUserName(Integer userId);
    public User getUserByName(String userName);

    User UpdateUser(User user);
    public User saveUser(User user);
}
