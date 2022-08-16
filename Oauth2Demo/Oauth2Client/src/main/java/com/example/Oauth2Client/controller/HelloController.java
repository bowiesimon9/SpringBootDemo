package com.example.Oauth2Client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Principal;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.*;

@RestController
public class HelloController {

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/api/hello")
    public String hello(Principal principal) {
        return "hello "+ principal.getName()+ ", welcome. ";
    }

    @GetMapping(value = {"/"})
    public String[] homeIndex() {
        return new String[]{"aaa","bbb"};
    }

    @GetMapping(value = {"/api/ok"})
    public String[] getOk(@RegisteredOAuth2AuthorizedClient("messaging-client-authorization-code")
                              OAuth2AuthorizedClient client) {
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/ok")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String[].class)
                .block();


    }
}
