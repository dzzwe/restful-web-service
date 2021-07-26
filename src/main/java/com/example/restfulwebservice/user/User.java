package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min=2)
    private String name;
    private Date joinData;
}
