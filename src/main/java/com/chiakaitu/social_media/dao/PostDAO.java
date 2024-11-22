package com.chiakaitu.social_media.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chiakaitu.social_media.entity.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {
}
