package com.example.java_springboot.controller;

import com.example.java_springboot.entity.Comment;
import com.example.java_springboot.entity.Reply;
import com.example.java_springboot.service.CommentService;
import com.example.java_springboot.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/admin")
public class ReplyController {

    @Autowired
    ReplyService replyService;


    @RequestMapping(method = RequestMethod.GET, path = "/replies")
    public List<Reply> getList() {
        return replyService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/replies")
    public Reply save(@RequestBody Reply reply) {
        replyService.save(reply);
        return reply;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/replies/{id}")
    public Reply getDetail(@PathVariable Integer id) {
        return replyService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/replies/{id}")
    public boolean delete(@PathVariable Integer id) {
        replyService.deleteById(id);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/replies/{id}")
    public Reply update(@PathVariable Integer id, @RequestBody Reply replyUpdate) {
        Reply existing = replyService.findById(id).get();
        existing.setContent(replyUpdate.getContent());
        existing.setStatus(replyUpdate.getStatus());
        replyService.save(existing);
        return replyUpdate;
    }

}

