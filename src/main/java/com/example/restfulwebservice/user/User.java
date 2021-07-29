package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"password"}) //json조회 시 무시되어 나타나지 않음
@JsonFilter("UserInfo")
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")
    private String name;

    @Past
    private Date joinData;

    private String password;
    private String ssn;
}
