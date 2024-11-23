package com.chiakaitu.social_media.service;

import com.chiakaitu.social_media.entity.User;
import java.util.Optional;


public interface UserService {
    Optional<User> findUserByPhoneNum(String phoneNum);
    Optional<User> findUserById(int userId);
    User createUser(User user);
    boolean validatePassword(String inputPassword, String storedHashedPassword);
    // List<User> getAllUsers();
    // User updateUserById(User user);
    // void deleteUserById(int userId);
}
