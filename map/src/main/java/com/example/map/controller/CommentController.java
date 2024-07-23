package com.example.map.controller;

import com.example.map.entity.Comment;
import com.example.map.entity.Post;
import com.example.map.service.CommentService;
import com.example.map.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private PostService postService;

    public CommentController( PostService postService) {

        this.postService = postService;
    }
    //http://localhost:8080/api/v1/comments?postId=1
@PostMapping
    public ResponseEntity<Comment> createComment(
            @RequestBody Comment comment,
            @RequestParam long postId
){

   Comment saveEntity =postService.createComment(comment, postId);
    return new ResponseEntity<>(saveEntity, HttpStatus.CREATED);
}


}
