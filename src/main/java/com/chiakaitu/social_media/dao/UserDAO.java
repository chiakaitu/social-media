package com.chiakaitu.social_media.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chiakaitu.social_media.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
    Optional<User> findByPhoneNum(String phoneNum);
}