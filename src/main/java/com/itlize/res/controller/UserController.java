package com.itlize.res.controller;

import com.itlize.res.entity.User;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){

        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id){
        Optional<User>  user = userService.getUserByID(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUserByID(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }




    
}
