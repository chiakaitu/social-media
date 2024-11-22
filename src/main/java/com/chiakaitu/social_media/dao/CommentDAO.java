package com.chiakaitu.social_media.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chiakaitu.social_media.entity.Comment;

public interface CommentDAO extends JpaRepository<Comment, Integer> {
}