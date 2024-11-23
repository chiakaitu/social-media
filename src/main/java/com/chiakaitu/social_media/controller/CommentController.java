package com.chiakaitu.social_media.controller;

import com.chiakaitu.social_media.entity.Comment;
import com.chiakaitu.social_media.service.CommentService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 取得留言列表

    // 發佈留言
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> addComment(@RequestBody Comment comment) {
        Map<String, String> response = new HashMap<>();
        try {
            commentService.addComment(comment);
            response.put("result", "0");
            response.put("message", "User add comment successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "1");
            response.put("message", "Failed to add comment: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
