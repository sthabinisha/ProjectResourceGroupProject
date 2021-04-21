package com.itlize.res.controller;

import com.itlize.res.entity.ProjectColumns;
import com.itlize.res.entity.User;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.repository.RoleRepository;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.security.JwtTokenProvider;
import com.itlize.res.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserMainController {
    private final UserServiceImpl userService;


    @Autowired
    public UserMainController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @GetMapping()
    public String hello() {
        return "Hello world!";
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }
    @GetMapping("/find/{user_id}")
    public ResponseEntity<Optional<User> > getUserByID(@PathVariable("user_id") Long id){
        Optional<User> user =  userService.getUserByID(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        if(userRepository.existsById(id)){
            userService.deleteUserByID(id);
            return ResponseEntity.ok(new ApiResponse(true, "Successfully deleted the userID: " + id));
        }else{
            return new ResponseEntity(new ApiResponse(false, "userID does not exist"), HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping("/update/{user_id}")
    public ResponseEntity<?> UpdateUserUserId(@PathVariable("user_id") Long id, @RequestBody User user){
        if(userRepository.existsById(id)){
            System.out.println(user);
            userService.updateTitleofUser(id,user);
            return ResponseEntity.ok(new ApiResponse(true, "Successfully updated the userID: " + id));
        }else{
            return new ResponseEntity(new ApiResponse(false, "userID does not exist"), HttpStatus.BAD_REQUEST);

        }


    }


}
