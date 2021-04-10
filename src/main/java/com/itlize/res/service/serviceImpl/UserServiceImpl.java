package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.User;
import com.itlize.res.exception.UserNotFoundException;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.security.UserPrincipal;
import com.itlize.res.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserDetailsService {


    @Autowired
    private UserRepository userRepository;


//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public String deleteUserByID(Integer uID) {
//         userRepository.deleteById(uID);
//        return "User removed !! " + uID;
//
//    }

////    @Override
////    public User getUserName(Integer userId) {
////        return userRepository.findById(userId) .orElseThrow(()-> new UserNotFoundException("User by userId: "+ userId+ " was not found"));
////
////    }
////
////
////
////    @Override
////    public User updateUser(User user) {
////        User existingUser = userRepository.findById(user.getUserID()).orElse(null);
////        existingUser.setUsername(user.getUsername());
//////        existingUser.setRole(user.getRole());
////
////        existingUser.setUsername(user.getUsername());
////
////
////
////        return userRepository.save(existingUser);
////    }
////
////    @Override
////    public User saveUser(User user) {
////        return userRepository.save(user);
////    }
////
////    @Override
////    public Optional<User>  getUserByID(Integer userId) {
////        return userRepository.findById(userId);
////    }
////
////    // This method is used by JWTAuthenticationFilter
////
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUserName(String usernameOrEmail) {
//        User user = userRepository. findAllByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
//                () -> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));
//
//        return UserPrincipal.create(user);
//
//    }

   // @Override
    @Transactional
    public UserDetails loadUserById(Integer userId) {
        User user = userRepository. findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username or email : " + userId));

        return UserPrincipal.create(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository. findAllByUsernameOrEmail(s, s).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username or email : " + s));

        return UserPrincipal.create(user);
    }
}
