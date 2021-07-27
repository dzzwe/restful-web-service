package com.example.restfulwebservice.helloworld;

import com.example.restfulwebservice.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //GET
    //hello-world -> endpoint
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    //alt+enter : 객체 신규 생성
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    //가변데이터 사용법
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping(path = "/hello-world-international")
    public String HelloWorldInternational(
            @RequestHeader(name="Accept-Language", required = false) Locale locale
            ){
        return messageSource.getMessage("greeting.message",null,locale);

    }
}
