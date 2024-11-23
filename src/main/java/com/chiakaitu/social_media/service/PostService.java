package com.chiakaitu.social_media.service;

import com.chiakaitu.social_media.entity.Post;
import java.util.List;


public interface PostService {
    // 取得貼文列表
    List<Post> getPosts();

    // 新增貼文
    Post addPost(Post post);

    // 以 userId 查詢貼文列表
    List<Post> getPostsByUserId(Integer userId);
}
