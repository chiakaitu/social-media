package com.chiakaitu.social_media.service.impl;

import com.chiakaitu.social_media.dao.PostDAO;
import com.chiakaitu.social_media.entity.Post;
import com.chiakaitu.social_media.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    private final PostDAO postDao;

    @Autowired
    public PostServiceImpl(PostDAO postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> getPosts() {
        return postDao.findAll();
    }

    @Override
    public Post addPost(Post post) {
        return postDao.save(post);
    }

    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        return postDao.findByUserIdOrderByCreatedAtDesc(userId);
    }
}
