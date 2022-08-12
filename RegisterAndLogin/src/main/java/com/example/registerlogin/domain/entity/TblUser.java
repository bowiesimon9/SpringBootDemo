package com.example.registerlogin.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class TblUser {

    @Id
    private long id;
    private String username;
    private String password;

}