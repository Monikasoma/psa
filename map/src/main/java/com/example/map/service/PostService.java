package com.example.map.service;

import com.example.map.entity.Comment;
import com.example.map.entity.Post;

public interface PostService {
    Post createPost(Post post);

    Comment createComment(Comment comment, long postId);
}
