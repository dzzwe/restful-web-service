package com.example.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "test1", new Date()));
        users.add(new User(2, "test2", new Date()));
        users.add(new User(3, "test3", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

}
