package com.chiakaitu.social_media.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @GetMapping("/hello") 
    public String hello() {
        return "My first Maven application using Vue.js & Spring Boot.";
    }
}
