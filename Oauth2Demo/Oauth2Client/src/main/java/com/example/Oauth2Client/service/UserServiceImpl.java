package com.example.Oauth2Client.service;

import com.example.Oauth2Client.entity.TblUser;
import com.example.Oauth2Client.entity.VerificationToken;
import com.example.Oauth2Client.model.UserModel;
import com.example.Oauth2Client.repository.UserRepository;
import com.example.Oauth2Client.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public TblUser registerUser(UserModel userModel) {
        TblUser user = new TblUser();
        user.setEmail(userModel.getEmail());
        user.setUsername(userModel.getUsername());
        String[] roles={"USER"};
        user.setRoles(roles);
        user.setPassword_(passwordEncoder.encode(userModel.getPassword()));

        userRepository.save(user);

        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, TblUser user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken =
                verificationTokenRepository.findByToken1(token);
        if(verificationToken == null) {
            return "invalid";
        }

        TblUser user = verificationToken.getUser();
        Calendar calendar = Calendar.getInstance();
        if(verificationToken.getExpirationTime().getTime()
        - calendar.getTime().getTime() <= 0) {
            verificationTokenRepository.delete(verificationToken);
            return "expired";
        }

        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }
}
