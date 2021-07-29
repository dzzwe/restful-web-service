package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "test1", new Date(),"pass1","701010-1111111"));
        users.add(new User(2, "test2", new Date(),"pass2","801010-1111111"));
        users.add(new User(3, "test3", new Date(),"pass3","901010-1111111"));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        for(User user : users){
            if(user.getId() == id){
                users.remove(user);
                return user;
            }
        }
        return null;
    }

    public User updateUser(User changeUser){
        for(User user : users){
            if(user.getId() == changeUser.getId()){
                users.remove(user);
                users.add(changeUser);
                return changeUser;
            }
        }
        return null;
    }

}
