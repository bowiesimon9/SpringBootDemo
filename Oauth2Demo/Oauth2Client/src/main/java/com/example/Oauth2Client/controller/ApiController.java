package com.example.Oauth2Client.controller;

import com.example.Oauth2Client.entity.TblUser;
import com.example.Oauth2Client.event.RegistrationCompleteEvent;
import com.example.Oauth2Client.model.UserModel;
import com.example.Oauth2Client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController
public class ApiController {

    private WebClient webClient;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        TblUser user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "success";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

    @GetMapping(value = "/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")) {
            return "User verifies successfully ";
        }
        return "Bad user.";
    }

}