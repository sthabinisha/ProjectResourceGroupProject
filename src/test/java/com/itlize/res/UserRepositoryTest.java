package com.itlize.res;

import com.itlize.res.entity.*;
import com.itlize.res.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectColumnsRepository projectColumnsRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectResourceRepository projectResourceRepository;
    @Autowired
    private ResourceDetailsRepository resourceDetailsRepository;
    @Autowired
    private ResourcesRepository resourcesRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        Project project = new Project();
        ProjectColumns projectColumns = new ProjectColumns();
        ProjectResource projectResource = new ProjectResource();
        Resource resource = new Resource();
        ResourceDetails resourceDetails = new ResourceDetails();

        user.setUsername("binisha");
        user.setTitle("Eng");
        user.setLastUpdated(Calendar.getInstance().getTime());
        user.setCreatedDate(Calendar.getInstance().getTime());

        user.setPassword("binsiha");

        User savedUser = userRepository.save(user);

        User existUser = testEntityManager.find(User.class, savedUser.getUserID());
        assertThat(existUser.getUsername()).isEqualTo(user.getUsername());

        //projectRepository.save(new Project(1, Calendar.getInstance().getTime(), user, projectColumns, projectResource));
        assertThat(projectRepository.findById(1)).isNotNull();




    }

}

