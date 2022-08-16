package com.example.Oauth2Client.service;

import com.example.Oauth2Client.entity.TblUser;
import com.example.Oauth2Client.model.UserModel;

public interface UserService {
    TblUser registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, TblUser user);

    String validateVerificationToken(String token);
}
