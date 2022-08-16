package com.example.Oauth2Client.event;

import com.example.Oauth2Client.entity.TblUser;
import com.example.Oauth2Client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create verification token for the user with link
        TblUser user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //send email to user
        String url = event.getApplicationUrl()
                +"/verifyRegistration?token="
                +token;

        //send verification email
        log.info("click the link to verify your account: {}", url);
    }
}
