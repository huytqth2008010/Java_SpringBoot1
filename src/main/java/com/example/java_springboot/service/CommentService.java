package com.example.java_springboot.service;

import com.example.java_springboot.entity.Category;
import com.example.java_springboot.entity.Comment;
import com.example.java_springboot.respository.CategoryRepository;
import com.example.java_springboot.respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(Integer id) {
        return commentRepository.findById(id);
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }
}
