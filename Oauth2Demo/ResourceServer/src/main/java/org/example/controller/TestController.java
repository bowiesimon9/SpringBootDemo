package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/articles")
    public String[] getArticles() {
        return new String[] { "Article 1", "Article 2", "Article 3" };
    }

    @GetMapping("/api/ok")
    public String[] getOk() {
        return new String[] { "OK 1", "ok 2", "OK 3" };
    }
}