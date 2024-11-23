package com.chiakaitu.social_media.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chiakaitu.social_media.dao.UserDAO;
import com.chiakaitu.social_media.entity.User;
import com.chiakaitu.social_media.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }
    
    @Override
    @Transactional
    public User createUser(User user) {
        
        // 可以在這裡添加密碼加密
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        return userDao.save(user);
    }

    // 根據 phoneNum 查找使用者
    @Override
    public Optional<User> findUserByPhoneNum(String phoneNum) {
        return userDao.findByPhoneNum(phoneNum);
    }

    // 密碼驗證
    @Override
    public boolean validatePassword(String inputPassword, String storedHashedPassword) {
        // return BCrypt.checkpw(inputPassword, storedHashedPassword);
        return inputPassword.equals(storedHashedPassword);
    }
    
    @Override
    public Optional<User> findUserById(int userId) {
        return userDao.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User updateUserById(User user) {
        if (userDao.existsById(user.getUserId())) {
            return userDao.save(user);
        }
        return null; // 或丟出自定義例外
    }

    @Override
    public void deleteUserById(int userId) {
        if (userDao.existsById(userId)) {
            userDao.deleteById(userId);
        }
    }
}