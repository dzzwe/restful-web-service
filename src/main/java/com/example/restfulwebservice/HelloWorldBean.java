package com.example.restfulwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;

//lombok 기능
@Data //setter, getter 등 자동 생성
@AllArgsConstructor //생성자 자동
public class HelloWorldBean {
    private String message;
}