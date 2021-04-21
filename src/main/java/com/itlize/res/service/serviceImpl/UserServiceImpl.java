package com.itlize.res.service.serviceImpl;

import com.itlize.res.entity.User;
import com.itlize.res.repository.UserRepository;
import com.itlize.res.security.UserPrincipal;
import com.itlize.res.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserDetailsService, UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUserByID(Long uID) {
         userRepository.deleteById(uID);
        return "User removed !! " + uID;

    }

    @Override
    public Optional<User> getUserByID(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void updateTitleofUser(Long id, User user) {

        User user1 = userRepository.findByUserId(id);

        user1.setTitle(user.getTitle());


        userRepository.save(user1);
    }

////    @Override
////    public User getUserName(Integer userId) {
////        return userRepository.findById(userId) .orElseThrow(()-> new UserNotFoundException("User by userId: "+ userId+ " was not found"));
////
////    }
////
////
////


////    @Override
////    public User saveUser(User user) {
////        return userRepository.save(user);
////    }
////







    // @Override
    @Transactional
    public UserDetails loadUserById(Long userId) {
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
