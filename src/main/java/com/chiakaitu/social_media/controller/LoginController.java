package com.chiakaitu.social_media.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chiakaitu.social_media.entity.LoginRequest;
import com.chiakaitu.social_media.entity.User;
import com.chiakaitu.social_media.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // 登入功能
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.findUserByPhoneNum(loginRequest.getPhoneNum());

        if (user.isPresent()) {
            // 密碼驗證
            boolean isPasswordValid = userService.validatePassword(loginRequest.getPassword(), user.get().getPassword());

            if (isPasswordValid) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
