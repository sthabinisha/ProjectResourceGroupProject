package com.itlize.res.controller;

import com.itlize.res.entity.Role;
import com.itlize.res.entity.RoleName;
import com.itlize.res.entity.User;
import com.itlize.res.payloads.ApiResponse;
import com.itlize.res.payloads.JwtAuthenticationResponse;
import com.itlize.res.payloads.LoginRequest;
import com.itlize.res.payloads.SignUpRequest;
import com.itlize.res.repository.RoleRepository;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.security.JwtTokenProvider;
import com.itlize.res.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

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
                passwordEncoder.encode(signUpRequest.getPassword()), Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), signUpRequest.getTitle());

        System.out.println(user.toString());

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        System.out.println(strRoles);
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleName.role_user)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "role_admin":
                        Role adminRole = roleRepository.findByName(RoleName.role_admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(RoleName.role_user)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }



       user.setRoles(roles);


        User result = userRepository.save(user);


        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
        System.out.println();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

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
