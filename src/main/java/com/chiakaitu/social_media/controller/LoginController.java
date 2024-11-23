package com.chiakaitu.social_media.controller;

import java.util.HashMap;
import java.util.Map;
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
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();
        Optional<User> user = userService.findUserByPhoneNum(loginRequest.getPhoneNum());

        if (user.isPresent()) {
            // 密碼驗證
            boolean isPasswordValid = userService.validatePassword(loginRequest.getPassword(), user.get().getPassword());

            if (isPasswordValid) {
                response.put("result", "0");
                response.put("message", "Login successful");
                return ResponseEntity.ok(response);
            } else {
                response.put("result", "1");
                response.put("message", "Invalid password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } else {
            response.put("result", "1");
            response.put("message", "User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}