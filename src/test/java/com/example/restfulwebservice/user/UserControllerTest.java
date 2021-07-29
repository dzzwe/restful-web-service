package com.example.restfulwebservice.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserDaoService service;

    @Test
    void retrieveAllUsers() {
        List<User> list = service.findAll();
        assertEquals(list.size(),3);
    }

    @Test
    void retrieveUser() {
    }

    @Test
    void createUser() {
        User user = new User(1, "test1", new Date(),"11","22");
        User user2 = service.save(user);
        assertEquals(user.getId(),user2.getId());
    }
}