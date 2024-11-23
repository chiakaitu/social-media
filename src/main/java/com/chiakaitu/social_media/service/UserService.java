package com.chiakaitu.social_media.service;

import java.util.List;
import java.util.Optional;

import com.chiakaitu.social_media.entity.User;

public interface UserService {
    Optional<User> findUserById(int userId);
    Optional<User> findUserByPhoneNum(String phoneNum);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUserById(User user);
    void deleteUserById(int userId);
    boolean validatePassword(String inputPassword, String storedHashedPassword);

}
