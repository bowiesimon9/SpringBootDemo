package com.example.Oauth2Client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private String username;
    private String email;
    private String password;
    private String matchingPassword;
}
