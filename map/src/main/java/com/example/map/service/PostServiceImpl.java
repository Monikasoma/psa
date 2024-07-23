package com.example.map.service;

import com.example.map.entity.Comment;
import com.example.map.entity.Post;
import com.example.map.repository.CommentRepository;
import com.example.map.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
private CommentRepository commentRepository;

public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
    this.postRepository = postRepository;
}

    @Override
    public Post createPost(Post post) {
        Post savedEntity = postRepository.save(post);
        return savedEntity;
    }

    @Override
    public Comment createComment(Comment comment, long postId) {
    Post post = postRepository.findById(postId).get();
    comment.setPost(post);
    Comment savedEntity = commentRepository.save(comment);
    savedEntity.setPost(post);
    return savedEntity;

    }


}
