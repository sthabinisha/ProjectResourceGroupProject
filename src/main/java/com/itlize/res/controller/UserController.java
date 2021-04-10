package com.itlize.res.controller;

import com.itlize.res.entity.Role;
import com.itlize.res.entity.RoleName;
import com.itlize.res.entity.User;
import com.itlize.res.exception.AppException;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.payloads.JwtAuthenticationResponse;
import com.itlize.res.payloads.LoginRequest;
import com.itlize.res.payloads.SignUpRequest;
import com.itlize.res.repository.RoleRepository;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.security.JwtTokenProvider;
import com.itlize.res.service.UserService;
import com.itlize.res.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserServiceImpl userService;


    @Autowired
    public UserController(UserServiceImpl userService) {
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
    
//    @PostMapping("/add")
//    public ResponseEntity<User> addUser(@RequestBody User user){
//
//        User newUser = userService.saveUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//    }
//    @PreAuthorize("isAuthenticated() || hasRole('ADMIN')")
//    @GetMapping("/all")
//    public ResponseEntity<List<User>> findAll() {
//        List<User> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//
//    }
//
//    @PreAuthorize("isAuthenticated() || hasRole('ADMIN')")
//    @GetMapping("/find/{id}")
//    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id){
//        Optional<User>  user = userService.getUserByID(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//
//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user){
//        User updateUser = userService.updateUser(user);
//        return new ResponseEntity<>(updateUser, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
//        userService.deleteUserByID(id);
//        return new ResponseEntity<>( HttpStatus.OK);
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
        }

        // Creating user's account

        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        System.out.println(user.toString());

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        System.out.println(strRoles);
        if (strRoles != null) {

            Role userRole = roleRepository.findByName(RoleName.role_user)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }


        //userRepository.save(user);

        System.out.println(user.getUserID());

        System.out.println(user.getUserID());


        User result = userRepository.save(user);


        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
        System.out.println();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

       // return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        System.out.println(loginRequest.getUsernameOrEmail());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }



    
}
