package com.chiakaitu.social_media.service.impl;

import com.chiakaitu.social_media.dao.CommentDAO;
import com.chiakaitu.social_media.entity.Comment;
import com.chiakaitu.social_media.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDao;

    @Autowired
    public CommentServiceImpl(CommentDAO commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.save(comment);
    }
}
