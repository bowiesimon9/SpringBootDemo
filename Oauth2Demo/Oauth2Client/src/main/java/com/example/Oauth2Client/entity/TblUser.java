package com.example.Oauth2Client.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class TblUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_;

    private String username;
    private String email;
    private String password_;
    private String[] roles;
    private boolean enabled = false;

}
