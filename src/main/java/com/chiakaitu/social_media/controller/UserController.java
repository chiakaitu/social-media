package com.chiakaitu.social_media.controller;

import com.chiakaitu.social_media.entity.User;
import com.chiakaitu.social_media.service.UserService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 取得使用者資訊
    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 註冊使用者
    @PostMapping
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        try {
            userService.createUser(user);
            response.put("result", "0");
            response.put("message", "User created successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "1");
            response.put("message", "Failed to create user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 修改使用者資訊
    // @PutMapping("/{id}")
    // public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
    //     Optional<User> existingUser = userService.findUserById(id);
    //     if (existingUser.isPresent()) {
    //         User user = existingUser.get();
    //         user.setUserName(updatedUser.getUserName());
    //         user.setEmail(updatedUser.getEmail());
    //         user.setBiography(updatedUser.getBiography());
    //         userService.updateUserById(user);
    //         return ResponseEntity.ok("User updated successfully.");
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // 刪除使用者
    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> deleteUser(@PathVariable int id) {
    //     Optional<User> existingUser = userService.findUserById(id);
    //     if (existingUser.isPresent()) {
    //         userService.deleteUserById(id);
    //         return ResponseEntity.ok("User deleted successfully.");
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
}