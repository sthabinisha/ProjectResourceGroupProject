package com.itlize.res;

import com.itlize.res.entity.User;
import com.itlize.res.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setUsername("binisha");
        user.setFirstName("Binisha");
        user.setLastName("Shrestha");
        user.setCreatedDate(Calendar.getInstance().getTime());
        user.setRole("Engineer");
        user.setPassword("binsiha");

        User savedUser = userRepository.save(user);

        User existUser = testEntityManager.find(User.class, savedUser.getUserID());
        assertThat(existUser.getUsername()).isEqualTo(user.getUsername());
    }

}

