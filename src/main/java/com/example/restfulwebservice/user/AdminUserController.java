package com.example.restfulwebservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }

        //심플 필터를 생성한다. (원하는 데이터)
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinData","ssn");

        //생성한 필터를 provider에 넣고 리턴할 MappingJacksonValue에 필터를 걸어준다.
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);
        return mapping;
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User changeUser = service.updateUser(user);
        if(changeUser == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",user.getId()));
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(changeUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }
}
