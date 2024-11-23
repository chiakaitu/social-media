package com.chiakaitu.social_media.controller;

import com.chiakaitu.social_media.entity.Post;
import com.chiakaitu.social_media.service.PostService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 取得訊息列表
    @GetMapping("/users/{id}/posts")
    public ResponseEntity<Map<String, Object>> getPostsByUserId(@PathVariable("id") Integer userId) {
        Map<String, Object> response = new HashMap<>();
        try {
            var posts = postService.getPostsByUserId(userId);

            response.put("result", "0");
            response.put("message", "success");
            response.put("details", posts);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "1");
            response.put("message", "Failed to retrieve posts: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 發佈貼文
    @PostMapping("/posts")
    public ResponseEntity<Map<String, String>> addPost(@RequestBody Post post) {
        Map<String, String> response = new HashMap<>();
        try {
            postService.addPost(post);
            response.put("result", "0");
            response.put("message", "User post successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("result", "1");
            response.put("message", "Failed to post: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
