package com.chiakaitu.social_media.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chiakaitu.social_media.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}