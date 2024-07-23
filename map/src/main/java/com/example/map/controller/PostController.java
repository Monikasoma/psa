package com.example.map.controller;


import com.example.map.entity.Post;
import com.example.map.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
private PostService postService;

public PostController(PostService postService){
    this.postService = postService;
}
@PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
    Post saved=postService.createPost(post);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
}
}
