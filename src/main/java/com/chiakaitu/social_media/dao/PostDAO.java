package com.chiakaitu.social_media.dao;

import com.chiakaitu.social_media.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PostDAO extends JpaRepository<Post, Integer> {
    // 以 userId 查詢貼文，按照 createdAt 降序排序
    List<Post> findByUserIdOrderByCreatedAtDesc(Integer userId);
}
