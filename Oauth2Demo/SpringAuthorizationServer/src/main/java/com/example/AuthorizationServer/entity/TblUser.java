package com.example.AuthorizationServer.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "tbl_user")
public class TblUser {
    @Id
    private long id_;
    private String username;
    private String email;
    private String password_;
    private String[] roles;
    private boolean enabled = false;

}
