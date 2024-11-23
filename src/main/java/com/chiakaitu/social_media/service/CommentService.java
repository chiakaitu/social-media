package com.chiakaitu.social_media.service;

import com.chiakaitu.social_media.entity.Comment;

public interface CommentService {
    // 發佈留言
    Comment addComment(Comment comment);

}
