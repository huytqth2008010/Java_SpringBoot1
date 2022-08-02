package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Comment;
import com.example.java_springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class CommentController {

    @Autowired
    CommentService commentService;


    @RequestMapping(method = RequestMethod.GET, path = "/comment")
    public List<Comment> getList() {
        return commentService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/comment")
    public Comment save(@RequestBody Comment comment) {
        commentService.save(comment);
        return comment;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/comment/{id}")
    public Comment getDetail(@PathVariable Integer id) {
        return commentService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/comment/{id}")
    public boolean delete(@PathVariable Integer id) {
        commentService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/comment/{id}")
    public Comment update(@PathVariable Integer id, @RequestBody Comment commentUpdate) {
        Comment existing = commentService.findById(id).get();
        existing.setContent(commentUpdate.getContent());
        existing.setStatus(commentUpdate.getStatus());
        commentService.save(existing);
        return commentUpdate;
    }

}

