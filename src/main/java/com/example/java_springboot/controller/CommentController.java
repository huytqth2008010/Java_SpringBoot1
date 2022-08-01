package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Category;
import com.example.java_springboot.entity.Comment;
import com.example.java_springboot.service.CategoryService;
import com.example.java_springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/user")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, path = "/comments")
    public Page<Comment> getList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "1") int limit) {
        return commentService.findAll(page, limit);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/comments/get-all")
    public List<Comment> getList() {
        return commentService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/comments")
    public Comment save(@RequestBody Comment comment) {
        commentService.save(comment);
        return comment;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/comments/{id}")
    public Comment getDetail(@PathVariable Integer id) {
        return commentService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/comments/{id}")
    public boolean delete(@PathVariable Integer id) {
        commentService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/comments/{id}")
    public Comment update(@PathVariable Integer id, @RequestBody Comment commentUpdate) {
        Comment existing = commentService.findById(id).get();
        existing.setContent(commentUpdate.getContent());
        commentService.save(existing);
        return commentUpdate;
    }

}
